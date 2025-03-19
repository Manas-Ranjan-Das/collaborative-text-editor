package com.example.operational_transform.sevices;

import com.example.operational_transform.dto.ChangeDTO;
import com.example.operational_transform.dto.EditDTO;
import com.example.operational_transform.dto.RangeDTO;

public class EditTransformations {
    

    EditDTO transformBasedOn(EditDTO editToTranform , EditDTO transformBasedOn){

        ChangeDTO change = transformBasedOn.getChanges().get(0);
        RangeDTO range = change.getRange();
        int numberOfLinesRemoved = range.getEndLineNumber()  -  range.getStartLineNumber();
        int numberOfExtraCharsRemoved = range.getEndColumn();

        String[] addedLines = change.getText().split("\n") ;
        int numberOfLinesAdded = addedLines.length - 1;
        int numberOfExtraCharsAdded = addedLines[addedLines.length-1].length();


        // TODO : 


        return editToTranform;
    }

}
