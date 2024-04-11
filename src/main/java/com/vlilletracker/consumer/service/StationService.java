package com.vlilletracker.consumer.service;

import com.vlilletracker.consumer.model.Station;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Service
public class StationService {

    private final HashSet<Station> stationHashSet = new HashSet<>();

    public void handleStationUpdate(Station newStationInfo) {
        log.debug("Libellé/number : {} / nom : {}", newStationInfo.getLibelle(), newStationInfo.getNom());
        Optional<Station> existingStation = this.findStationInHashSet(newStationInfo);

        if (existingStation.isPresent()) {
            if (existingStation.get().equals(newStationInfo)) {
                log.debug("No changes detected for station : {} {}", existingStation.get().getLibelle(), existingStation.get().getNom());
            } else {
                log.debug("Changes detected for station : {} {}", existingStation.get().getLibelle(), existingStation.get().getNom());
                this.updateStationInHashSet(existingStation.get(), newStationInfo);
            }
        } else {
            stationHashSet.add(newStationInfo);
        }
    }

    private void updateStationInHashSet(Station oldStationInfo, Station newStationInfo) {
        stationHashSet.remove(oldStationInfo);
        stationHashSet.add(newStationInfo);
        log.debug("Number of station in hashset : {}", stationHashSet.size());

        //FIXME Have another way to detect changes to exclude timestamp update only
        if (oldStationInfo.getNbvelosdispo() != (newStationInfo.getNbvelosdispo())) {
            this.displayChangesForStations(oldStationInfo, newStationInfo);
        }
    }

    private void displayChangesForStations(Station oldStationInfo, Station newStationInfo) {
        int variationNbVelos = newStationInfo.getNbvelosdispo() - oldStationInfo.getNbvelosdispo();
        int minusOne = -1;
        log.debug("variation nb velos : {}", variationNbVelos);
        if (variationNbVelos > 0) {
            log.info("{} vélos déposés à la station n°{} {}, nb de places restantes : {}", variationNbVelos, newStationInfo.getLibelle(), newStationInfo.getNom(), newStationInfo.getNbplacesdispo());
        } else if (variationNbVelos < 0) {
            log.info("{} vélos retiré à la station n°{} {}, nb de vélos restants : {}", variationNbVelos*minusOne, newStationInfo.getLibelle(), newStationInfo.getNom(), newStationInfo.getNbvelosdispo());
        } else { //FIXME cannot be reach as is but should be
            log.error("Aucun changement du nb de vélos détecté mais update, ancienne info : {} - nvx infos : {}", oldStationInfo, newStationInfo);
        }
    }

    private Optional<Station> findStationInHashSet(Station newStation) {
        for(Station existingStation: stationHashSet) {
            if (existingStation.areStationsTheSame(newStation)) {
                return Optional.of(existingStation);
            }
        }

        return Optional.empty();
    }
}
