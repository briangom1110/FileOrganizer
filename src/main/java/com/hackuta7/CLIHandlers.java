package com.hackuta7;

import java.util.Arrays;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class CLIHandlers {

    Terminal terminal;

    public CLIHandlers() throws Exception { 

        terminal = new DefaultTerminalFactory().createTerminal();
    }

    public void run () throws Exception {
     
        Screen screen = new TerminalScreen(terminal);

        screen.startScreen();

        BasicWindow window = new BasicWindow();
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);

        window.setHints(Arrays.asList(Window.Hint.FULL_SCREEN));

        boolean state = true;
        
        while(state) {
            // fn call to take user input
            String input = reader();
            String [] args; 

            if (input != null) {
                // args = splitArgs(input);
            }
            System.out.println(input);
        }

        screen.close();
    }

    public String reader() throws Exception { 
        String input;

        StringBuilder builder = new StringBuilder();
        KeyStroke keyStroke;

        while (true) {
            // Take input from terminal scene and record entry into a string format
            keyStroke = terminal.readInput();
            if (keyStroke.getKeyType() == KeyType.Enter) {
                break;
            }
            else if (keyStroke.getKeyType() == KeyType.Backspace && builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            else if (keyStroke.getCharacter() != null) {
                builder.append(keyStroke.getCharacter());
            }
            terminal.flush();
        }

        input = builder.toString();

        return input;
    }

    // public String [] splitArgs (String input) {

    //     String [] args;
    //     int size = args.length; 

    //     for (int i = 0; i < size; i++ ) { 
            
    //     }
    //     return args;
    // }

    public static void main(String[] args) throws Exception {
        CLIHandlers cli = new CLIHandlers();
        cli.run();
    }

}
