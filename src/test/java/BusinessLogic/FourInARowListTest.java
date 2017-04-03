package BusinessLogic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class FourInARowListTest {

    @Test
    public void testFourInARowListWorks() throws Exception {
        FourInARowList fourInARowList = new FourInARowList();

        /**
         * Should contain 6 Columns and 7 Rows all CirclePiece which is Empty
         */
        System.out.println(fourInARowList);
    }

}