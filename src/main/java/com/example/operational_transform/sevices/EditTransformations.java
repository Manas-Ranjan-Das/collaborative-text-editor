package com.example.operational_transform.sevices;

import com.example.operational_transform.dto.ChangeDTO;
import com.example.operational_transform.dto.EditDTO;
import com.example.operational_transform.dto.RangeDTO;

public class EditTransformations {

    // Happens before in terms of postion
    int ocuresAfter (RangeDTO range1 , RangeDTO range2){
        if(range1.getStartLineNumber() > range2.getStartLineNumber()){
            return 2;
        }
        else if (range1.getStartLineNumber() < range2.getStartLineNumber()){
            return 1;
        }
        else{
            if(range1.getStartColumn() > range2.getStartColumn()){
                return 2;
            }
            else if(range1.getStartColumn() > range2.getStartColumn()){
                return 1;
            }
            else{
                return 1;
            }
        }


    }

    // The forst edit is the ideal one to tranform and keep the second same 
    void tranformOneOnOther (EditDTO edit1 , EditDTO edit2){
        RangeDTO range1 = edit1.getChanges().get(0).getRange();
        RangeDTO range2 = edit2.getChanges().get(0).getRange();

        int tempReturn = ocuresAfter(range1, range2);

        if(tempReturn == 1){
            transformBasedOn(edit1, edit2);
        }
        else{
            transformBasedOn(edit2, edit1);
        }

    }
 

    EditDTO transformBasedOn(EditDTO tranformationSubject , EditDTO transformationReference){
        
        ChangeDTO changeReference = transformationReference.getChanges().get(0);
        RangeDTO rangeReference = changeReference.getRange();
        int numberOfLinesRemoved = rangeReference.getEndLineNumber()  -  rangeReference.getStartLineNumber();
        int numberOfExtraCharsRemoved = rangeReference.getEndColumn();


        String[] addedLines = changeReference.getText().split("\n") ;
        int numberOfLinesAdded = addedLines.length - 1;
        int numberOfExtraCharsAdded = addedLines[addedLines.length-1].length();

        ChangeDTO changeSubject = tranformationSubject.getChanges().get(0);
        RangeDTO rangeSubject = changeSubject.getRange();

        if( rangeReference.getEndLineNumber() > rangeSubject.getStartLineNumber() ){
            rangeSubject.setStartLineNumber(rangeReference.getEndLineNumber());
            rangeSubject.setStartColumn(rangeReference.getEndColumn());
        }
        else if(rangeReference.getEndLineNumber() == rangeSubject.getStartLineNumber()  && rangeReference.getEndColumn() > rangeSubject.getStartColumn() ){
            rangeSubject.setStartLineNumber(rangeReference.getEndLineNumber());
            rangeSubject.setStartColumn(rangeReference.getEndColumn());
        }

        if( rangeReference.getEndLineNumber() > rangeSubject.getEndLineNumber() ){
            rangeSubject.setEndLineNumber(rangeReference.getEndLineNumber());
            rangeSubject.setEndColumn(rangeReference.getEndColumn());
        }
        else if(rangeReference.getEndLineNumber() == rangeSubject.getEndLineNumber()  && rangeReference.getEndColumn() > rangeSubject.getEndColumn() ){
            rangeSubject.setEndLineNumber(rangeReference.getEndLineNumber());
            rangeSubject.setEndColumn(rangeReference.getEndColumn());
        }
        

        rangeSubject.setStartLineNumber(rangeSubject.getStartLineNumber() - numberOfLinesRemoved + numberOfLinesAdded);
        rangeSubject.setEndLineNumber(rangeSubject.getEndLineNumber() - numberOfLinesRemoved + numberOfLinesAdded);

        if(rangeSubject.getStartLineNumber() == rangeReference.getEndLineNumber() ){
            rangeSubject.setStartColumn(rangeSubject.getStartColumn() - numberOfExtraCharsRemoved + numberOfExtraCharsAdded);
        }

        return tranformationSubject;
    }

}
