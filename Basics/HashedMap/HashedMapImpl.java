package Basics.HashedMap;


import java.util.logging.Level;
import java.util.logging.Logger;

public class HashedMapImpl {
    private static final Logger logger = Logger.getLogger(HashedMapImpl.class.getName());

        public static void main(String[] args) {
            HashedMap<String, Integer> map = new HashedMap<>();
            map.put("apple", 10);
            map.put("banana", 20);

            logger.log(Level.INFO, "apple: {0}", map.get("apple"));
            logger.log(Level.INFO, "banana: {0}", map.get("banana"));

            map.put("apple", 15); // update value
            logger.log(Level.INFO, "apple after update: {0}", map.get("apple"));

            map.remove("banana");
            logger.log(Level.INFO, "banana after removal: {0}", map.get("banana"));
        }
    
}
