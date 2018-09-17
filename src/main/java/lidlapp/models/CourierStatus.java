package lidlapp.models;

public enum CourierStatus {
    NOT_DEPPARTED,
    ON_THE_WAY,
    ON_THE_WAY_BACK, // new orders can not be added
    ARRIVED
}
