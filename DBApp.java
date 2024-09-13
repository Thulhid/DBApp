public class DBApp{
  public static void main(String[] args) {
    StudentDao std = new StudentDao();
    String studentArray[][] = std.getAll();


    for(int i =0; i < studentArray.length; i++ ){

      for(int j =0; j < studentArray[0].length; j++){
        System.out.print(studentArray[i][j] + "\t\t");
      }
      System.out.println(" ");
    }

  }
}