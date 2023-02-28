package fr.educentre.demo.services;

import fr.educentre.demo.domain.Reservation;
import fr.educentre.demo.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static int currentReference = 238394;

    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public Reservation book(Reservation reservation) {
        reservation.setReference(++ReservationServiceImpl.currentReference);
        reservationRepository.save(reservation);
        return reservation;
    }
    @Override
    public void cancel(int reference) {
        reservationRepository.delete(findByReference(reference));
    }
    @Override
    public Reservation findByReference(int reference) {
        return reservationRepository.findByReference(reference);
    }
    @Override
    public Reservation changeReservationClient(Reservation reservation, String client) {
        reservation.setFullname(client);
        return reservationRepository.save(reservation);
    }

}
