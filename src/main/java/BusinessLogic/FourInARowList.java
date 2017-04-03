package BusinessLogic;

import org.apache.commons.collections4.list.FixedSizeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class FourInARowList {

    List<FixedSizeList<CirclePiece>> FourInARowList;

    public FourInARowList() {
        FourInARowList = createNewFourInARowList();
    }

    private List<FixedSizeList<CirclePiece>> createNewFourInARowList(){
        List<FixedSizeList<CirclePiece>> returnFourInARowList = new ArrayList<>();

        int rowCounter = 0;

        while(rowCounter != 6){
            returnFourInARowList.add(FixedSizeList.fixedSizeList((Arrays.asList(new CirclePiece[7]))));

            FixedSizeList<CirclePiece> circlePieceList = returnFourInARowList.get(rowCounter);

            for (int circlePiece = 0; circlePiece < circlePieceList.size(); circlePiece++) {
                circlePieceList.set(circlePiece, new CirclePiece("White"));
            }
            rowCounter++;
        }

        return returnFourInARowList;
    }

    @Override
    public String toString() {
        return  "FourInARowList=" + FourInARowList +
                '}';
    }
}
