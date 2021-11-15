package com.dkit.gd2.johnloane;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location>
{
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    //Anything that is in the static region will be called
    //before the constructor - this is useful for setting
    //up the game locations

    public static void main(String[] args)
    {
        //Modern way - try with resources - the will file will
        //automatically be closed for us - nice!
        try (FileWriter locationsFile = new FileWriter("locations.txt"); FileWriter directionsFile = new FileWriter("directions.txt"))
        {
            for (Location location : locations.values())
            {
                locationsFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet())
                {
                    directionsFile.write(location.getLocationID()+","+direction+","+location.getExits().get(direction)+"\n");
                }
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
//        FileWriter locationsFile = null;
//        try
//        {
//            locationsFile = new FileWriter("locations.txt");
//            for(Location location : locations.values())
//            {
//                locationsFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        }
//        catch(IOException ioe)
//        {
//            System.out.println("In the catch block");
//            ioe.printStackTrace();
//        }
//        finally
//        {
//            System.out.println("In the finally block");
//            try
//            {
//                if(locationsFile != null)
//                {
//                    System.out.println("Attempting to close the file");
//                    locationsFile.close();
//                }
//            }
//            catch(IOException ioe)
//            {
//                ioe.printStackTrace();
//            }
//        }

    //}

    static
    {
        Scanner fileScanner = null;
        try
        {
            fileScanner = new Scanner(new FileReader("locations.txt"));
            fileScanner.useDelimiter(",");
            while(fileScanner.hasNextLine())
            {
                int loc = fileScanner.nextInt();
                fileScanner.skip(fileScanner.delimiter());
                String description = fileScanner.nextLine();
                System.out.println("Imported location " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        }
        catch(FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        finally
        {
            if(fileScanner != null)
            {
                fileScanner.close();
            }
        }

        //Now read in the exits
        try
        {
            fileScanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
            
        }


//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer, learning Java", null));
//
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//
//        locations.put(1, new Location(1, "You have entered into a server room", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//
//        locations.put(2, new Location(2, "You have entered a brightly lit room. You notice that there is a counter with various items that could make tea", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//
//        locations.put(3, new Location(3, "You have entered a dimly lit room with no items on the counter for making tea", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//
//        locations.put(4, new Location(4, "You are in a medium lit room with no counter", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//
//        locations.put(5, new Location(5, "You have entered a room with blood red walls. You notice a table that has a cup of black coffee and a flashlight", tempExit));
    }



    @Override
    public int size()
    {
        return locations.size();
    }

    @Override
    public boolean isEmpty()
    {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key)
    {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key)
    {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value)
    {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key)
    {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m)
    {

    }

    @Override
    public void clear()
    {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet()
    {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values()
    {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet()
    {
        return locations.entrySet();
    }
}
