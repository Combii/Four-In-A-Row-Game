package BusinessLogic;

import org.apache.commons.collections4.list.FixedSizeList;

import java.util.Arrays;
import java.util.List;


/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class FourInARowList {

    private List<List<CirclePiece>> FourInARowList;

    FourInARowList() {
        FourInARowList = createNewFourInARowList();
    }

    public List<List<CirclePiece>> getFourInARowList() {
        return FourInARowList;
    }

    @SuppressWarnings("unchecked")
    private List<List<CirclePiece>> createNewFourInARowList(){
        FixedSizeList<List<CirclePiece>> returnFourInARowList = FixedSizeList.fixedSizeList((Arrays.asList(new FixedSizeList[6])));

        int rowCounter = 0;

        while(rowCounter != 6){
            returnFourInARowList.set(rowCounter ,FixedSizeList.fixedSizeList((Arrays.asList(new CirclePiece[7]))));

            List<CirclePiece> circlePieceList = returnFourInARowList.get(rowCounter);

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
