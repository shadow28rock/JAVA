package sample.control;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import sample.model.Model;

public class Ctrl {
    public Button btn00;
    public Button btn01;
    public Button btn02;
    public Button btn10;
    public Button btn11;
    public Button btn12;
    public Button btn20;
    public Button btn21;
    public Button btn22;

    private int[][] matrix;
    private Model model;

    public Ctrl()
    {
        matrix = new int[3][3];
        model = new Model();
    }
    private String lastSymbol = "x";

    //символы
    public void Simbols(ActionEvent actionEvent) {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray(); //получили все кнопки на форме
        for(int i=0; i< arr.length; i++) {
            Button cur_btn = (Button) arr[i]; //текущая кнопка
            if (actionEvent.getSource().equals(cur_btn) && cur_btn.getText() == "") {
                cur_btn.setText(lastSymbol);
                first(cur_btn);
                Mod_LastSimbol();
                int iRow = model.sameIntoRow(matrix);
                int iColumn = model.sameIntoColumn(matrix);
                int iDiagonalb = model.sameIntoDiag(matrix);
                //победитель в строке
                if (iRow > -1)
                {
                   DrawRowWIN(iRow);
                }
                //столбец
                if (iColumn > -1)
                {
                    DrawColumnWIN(iColumn);
                }
                if (iDiagonalb > -1)
                    reDrawDiagonal(iDiagonalb);
            }
        }
    }

    private void DrawColumnWIN(int index)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray();
        for(int i=0; i< arr.length; i++){
            Button btn = (Button) arr[i];
            String input = btn.getId().substring(3);
            int num_col = Integer.parseInt(input.substring(1));
            if (num_col == index)
                btn.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        }
    }

    private void DrawRowWIN(int ind)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray();
        for(int i=0; i< arr.length; i++){
            Button btn = (Button) arr[i];
            String input = btn.getId().substring(3);
            int num_row = Integer.parseInt(input.substring(0, 1));
            if (num_row == ind)
                btn.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        }
    }

    private  void reDrawDiagonal(int index)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray();
        if (index == 0) {
            for (int i = 0; i < arr.length; i++) {
                Button btn = (Button) arr[i];
                String input = btn.getId().substring(3);
                int num_col = Integer.parseInt(input.substring(1));
                int num_row = Integer.parseInt(input.substring(0, 1));

                if (num_col == index && num_row == index) {
                    btn.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    index++;
                }
            }
        }
        else if (index==2)
        {   for (int i = 0; i < arr.length; i++) {
            Button btn = (Button) arr[i];
            String input = btn.getId().substring(3);
            int num_col = Integer.parseInt(input.substring(1));
            int num_row = Integer.parseInt(input.substring(0, 1));
            //2,0; 1,1; 0;2
            if ((num_col == 2 && num_row == 0) || (num_col == 1 && num_row == 1)|| (num_col == 0 && num_row == 2)) {
                btn.setStyle("-fx-background-color: green; -fx-text-fill: white;");
            }
            }
        }
    }

    private void first(Button btn)
    {   String input = btn.getId().substring(3);
        int num_row = Integer.parseInt(input.substring(0, 1));
        int num_col = Integer.parseInt(input.substring(1));
        if (lastSymbol =="x")
        {
            matrix[num_row][num_col] = 2;
        }
        else
        {
            matrix[num_row][num_col] = 1;
        }

    }

    private void Mod_LastSimbol()
    {
        if (lastSymbol =="x") lastSymbol = "o";
        else lastSymbol = "x";
    }
    public void clearField(ActionEvent actionEvent)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray(); //получили все кнопки на форме
        for(int i=0; i< arr.length;i++)
        {
            Button cur_btn = (Button) arr[i];
            if (cur_btn.getId() != "btnClear") {
                cur_btn.setText("");
                cur_btn.setStyle("-fx-background-color: silver; -fx-text-fill: black;");
                matrix = new int[3][3];
            }
        }
        lastSymbol = "x";
    }
}
