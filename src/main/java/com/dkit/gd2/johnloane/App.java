package com.dkit.gd2.johnloane;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * Text based Adventure!!!!!!!!
 *
 */
public class App 
{
    private static Locations locations = new Locations();
    public static void main( String[] args )
    {
        System.out.println( "Welcome to The Shining!!!!!!!!!!!!!!" );
        Scanner keyboard = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("SOUTH", "S");

        int loc = 1;
        while(true)
        {
            System.out.println(locations.get(loc).getDescription());

            if(loc==0)
            {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are: ");
            for(String exit: exits.keySet())
            {
                System.out.println(exit + ", ");
            }
            System.out.println();

            System.out.print("Where would you like to go > ");
            String direction = keyboard.nextLine().toUpperCase();
            if(direction.length() > 1)
            {
                String[] words = direction.split(" ");
                for(String word: words)
                {
                    if(vocabulary.containsKey(word))
                    {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if(exits.containsKey(direction))
            {
                loc = exits.get(direction);
            }
            else
            {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
