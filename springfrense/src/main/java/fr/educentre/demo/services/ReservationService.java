package fr.educentre.demo.services;

import fr.educentre.demo.domain.Reservation;

public interface ReservationService {
    public Reservation book(Reservation reservation);
    public void cancel(int reference);
    public Reservation findByReference(int reference);
    public Reservation changeReservationClient(Reservation reservation, String client);
}
