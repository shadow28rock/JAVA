package sample.model;

public class Model {
    private int what_row;
    public  Model()
    {
        //������ �����������
    }
    public void Analize()
    {
        //��������� ������� ���������, ������� ����� ���������
    }
    //���������, ���� �� � ���� ���������� �������
    public int sameIntoRow(int[][] matrix)
    {
        for(int i=0; i< 3; i++)
        {   int count = 0;
            for(int j=0; j<2; j++)
            {
                if (matrix[i][j]> 0 && matrix[i][j] == matrix[i][j+1])
                    ++count;
            }
            if (count == 2)//� �����-���� ���� ���� ���������� �������
            {
               return i;
            }
            count = 0;
        }
        return -1;
    }
    //�� ��������
    public int sameIntoColumn(int[][] matrix)
    {
        for(int i=0; i < 3; i++) //����� �� ��������
        {   int count = 0;
            for(int j=0; j<2; j++) //����� �� �������
            {
                if (matrix[j][i]>0 && matrix[j][i] == matrix[j+1][i])
                    ++count;
            }
            if (count == 2)//� �����-���� ���� ���� ���������� �������
            {
                return i;
            }
            count = 0;
        }
        return -1;
    }
    public int sameIntoDiag(int[][]matrix)
    {   int count = 0;
        //�� ����� �������� 1 ��� -1
        int i;
        for(i=0; i<2; i++)
        {
            if (matrix[i][i]>0 && matrix[i][i] == matrix[i+1][i+1])
                ++count;
        }
        if (count == 2)
            return 0;

        if (matrix[2][0] > 0 && matrix[2][0]== matrix[1][1] && matrix[1][1] == matrix[0][2])
            return 2;
        return -1;
    }

}
