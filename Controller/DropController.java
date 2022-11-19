//package Controller;
//
//import Model.*;
//import View.BoardFrame;
//
//import java.awt.dnd.DropTargetDragEvent;
//import java.awt.dnd.DropTargetDropEvent;
//import java.awt.dnd.DropTargetEvent;
//import java.awt.dnd.DropTargetListener;
//import java.awt.event.InputMethodEvent;
//import java.awt.event.InputMethodListener;
//
//public class DropController implements InputMethodListener {
//
//    private Game game;
//    private BoardFrame view;
//
//    public DropController(Game g, BoardFrame v){
//        this.game = g;
//        this.view = v;
//    }
//
//
//    @Override
//    public void inputMethodTextChanged(InputMethodEvent event) {
//        if(!view.tile_content.getText().isEmpty()){
//            System.out.println("full");
//        }
//    }
//
//    @Override
//    public void caretPositionChanged(InputMethodEvent event) {
//
//    }
//}
