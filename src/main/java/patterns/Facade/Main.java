package patterns.Facade;

import java.util.Date;


class HotelBooking {
    public boolean isAvailable(Date startDate, Date endDate) {
        //If bookings are available within date Range...send true else false
        return true;
    }

}

class FlightBooking {
    public boolean isAvailable(Date startDate, Date endDate) {
        //If bookings are available within date Range...send true else false
        return true;
    }
}

class TravelFacade {
    private HotelBooking hotelBooking;
    private FlightBooking flightBooking;

    public TravelFacade() {
        hotelBooking = new HotelBooking();
        flightBooking = new FlightBooking();
    }

    public boolean isBookingPossible(Date startDate, Date endDate) {
        boolean isHotelAvailable = hotelBooking.isAvailable(startDate, endDate);
        boolean isFlightAvailable = flightBooking.isAvailable(startDate, endDate);

        if ( isHotelAvailable && isFlightAvailable ) {
            return true;
        } else {
            return false;
        }

    }
}

public class Main {
    public static void main(String args[]) {
        Date someStartDate = new Date();
        Date someEndDate = new Date();

        TravelFacade facade = new TravelFacade();
        facade.isBookingPossible(someStartDate, someEndDate);

    }

}
