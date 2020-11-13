package lukasz.nowogorski.domain.service;

public interface RoomAvailableService {

    void getFreeRoom(Long beds);
    void getBusyRoom(Long beds);
}
