package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data  
public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
//  private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;



    public double calculateTicketPrice(Showing showing) {
    //	private LocalDateTime showStartTime
        return ticketPrice - getDiscount(showing.getSequenceOfTheDay(),showing.getStartTime());
    }

    private double getDiscount(int showSequence, LocalDateTime localDateTime) {
        double specialDiscount = 0;
     //   System.out.println(localDateTime.getHour());
        if (localDateTime.getHour()>11 && localDateTime.getHour()<=16 ) {
            specialDiscount = ticketPrice * 0.25;  // 25% discount for Any movies showing starting between 11AM ~ 4pm
        } else if(MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {

            sequenceDiscount = 2; // $2 discount for 2nd show
       
    } else if (showSequence == 7) {

        sequenceDiscount = 1; // $1 discount for 7th show
    }       
//        else {
//            throw new IllegalArgumentException("failed exception");
//        }

        // biggest discount wins
        return specialDiscount > sequenceDiscount ? specialDiscount : sequenceDiscount;
    }


}