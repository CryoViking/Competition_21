public class Main
{
    public static void main(String[] args)
    {
        String level_file = IO.getString("Filename of level file: ");
        Map map = IO.constructMapSize(level_file);

        String input_string = IO.getString("Input moves");
        for(char c : input_string.toCharArray())
        {
            switch(c)
            {
                case '>':
                    map.move(0,1);
                    break;
                case '<':
                    map.move(0,-1);
                    break;
                case '^':
                    map.move(-1,0);
                    break;
                case 'v':
                    map.move(1,0);
                    break;
            }//END SWITCH
            if(map.isEnd())
                System.out.println("The Level is beatable with those set of moves!");
        }//END FOR
        if(!map.isEnd())
            System.out.println("This set of moves will not complete the level!");
    }//END main
}//END class Main