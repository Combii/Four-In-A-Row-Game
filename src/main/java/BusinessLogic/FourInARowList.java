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

    public boolean setBrick(int column, Color color){

        for(int row = fourInARowList.size()-1; row >= 0; row--){
            CirclePiece circlePiece = fourInARowList.get(row).get(column);

            if(circlePiece.getColor().equals(Color.WHITE)){
                circlePiece.setColor(color);
                return checkIfFourInARow(row, column, color);
            }
        }
        return false;
    }

    private boolean checkIfFourInARow(int row, int column, Color color){

        /**
         * Yes I know this is code smell. F it. You're Welcome to break this down to same method calling it 4 times.
         */


        //Check Right
        int fourInARowCounter = 0;
        for(int columnCounter = column; columnCounter < fourInARowList.get(row).size(); columnCounter++){
            if(checkIfColorEqualsColorInList(row, columnCounter, color))
                fourInARowCounter++;
            else
                break;

            if (fourInARowCounter == 4)
                return true;
        }

        //Check Left
        fourInARowCounter = 0;
        for(int columnCounter = column; columnCounter >= 0; columnCounter--){
            if(checkIfColorEqualsColorInList(row, columnCounter, color))
                fourInARowCounter++;
            else
                break;

            if (fourInARowCounter == 4)
                return true;
        }


        //Check Down
        fourInARowCounter = 0;
        for(int rowCounter = row; rowCounter < fourInARowList.size(); rowCounter++){
            if(checkIfColorEqualsColorInList(rowCounter, column, color))
                fourInARowCounter++;
            else
                break;

            if (fourInARowCounter == 4)
                return true;
        }





        return false;
    }


    private boolean checkIfColorEqualsColorInList(int row, int column, Color color){
        return fourInARowList.get(row).get(column).getColor().equals(color);
    }

    @Override
    public String toString() {
        return  "FourInARowList=" + fourInARowList +
                '}';
    }
}
