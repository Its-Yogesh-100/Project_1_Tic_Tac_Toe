package com.example.tic_tack_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     boolean isWinner=false;
     int imageClicked=-1;
     int player=1;
     int [][]winningState={{0,1,2,},{3,4,5,},{6,7,8}};
     int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1,};


     public void load(View view)
     {
         ImageView v =(ImageView) view;
         int tag = Integer.parseInt(v.getTag().toString());
         imageClicked=gameState[tag];
         if(!isWinner && imageClicked==-1)
         {
             if (player == 1)
             {
                 v.setImageResource(R.drawable.cross);
                 gameState[tag] = player;
                 Toast.makeText(this, "Cross", Toast.LENGTH_SHORT).show();
                 player = 0;
             }
             else
             {
                 v.setImageResource(R.drawable.zero);
                 gameState[tag] = player;
                 Toast.makeText(this, "zero", Toast.LENGTH_SHORT).show();
                 player = 1;
             }

             for(int i = 0; i < winningState.length; i++)
             {
                 if(gameState[winningState[i][0]] == gameState[winningState[i][1]] && gameState[winningState[i][1]] == gameState[winningState[i][2]] && gameState[winningState[i][0]] > -1)
                 {
                     Toast.makeText(this, " Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                 }
             }

         }

     }

       public  void reset(View view)
       {
           GridLayout gridlayout=findViewById(R.id.gridlayout);
           int total_images= gridlayout.getChildCount();
           for(int i=0;i<total_images;i++)
           {
               ImageView v=(ImageView) gridlayout.getChildAt(1);
               v.setImageDrawable(null);
           }
           isWinner=false;
           imageClicked=-1;
           for(int i=0;i<gameState.length;i++)
               gameState[i]=-1;
       }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}