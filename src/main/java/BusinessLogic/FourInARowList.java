package BusinessLogic;

import javafx.scene.paint.Color;
import org.apache.commons.collections4.list.FixedSizeList;

import java.util.Arrays;
import java.util.List;


/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class FourInARowList {

    private List<List<CirclePiece>> fourInARowList;

    public FourInARowList() {
        fourInARowList = createNewFourInARowList();
    }

    public List<List<CirclePiece>> getFourInARowList() {
        return fourInARowList;
    }

    @SuppressWarnings("unchecked")
    private List<List<CirclePiece>> createNewFourInARowList(){
        FixedSizeList<List<CirclePiece>> returnFourInARowList = FixedSizeList.fixedSizeList((Arrays.asList(new FixedSizeList[6])));

        int rowCounter = 0;

        while(rowCounter != 6){
            returnFourInARowList.set(rowCounter ,FixedSizeList.fixedSizeList((Arrays.asList(new CirclePiece[7]))));

            List<CirclePiece> circlePieceList = returnFourInARowList.get(rowCounter);

            for (int circlePiece = 0; circlePiece < circlePieceList.size(); circlePiece++) {
                circlePieceList.set(circlePiece, new CirclePiece(Color.WHITE, rowCounter, circlePiece));
            }
            rowCounter++;
        }

        return returnFourInARowList;
    }

    public void setBrick(int column, Color color){

        for(int row = fourInARowList.size()-1; row >= 0; row--){
            CirclePiece circlePiece = fourInARowList.get(row).get(column);

            if(circlePiece.getColor().equals(Color.WHITE)){
                circlePiece.setColor(color);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return  "FourInARowList=" + fourInARowList +
                '}';
    }
}
