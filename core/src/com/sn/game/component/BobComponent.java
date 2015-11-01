package com.sn.game.component;

import com.badlogic.ashley.core.Component;

public class BobComponent implements Component {

  public static final int STATE_IDLE = 0;
  public static final int STATE_THROW = 1;
  public static final int STATE_LOOK = 2;
  public static final int STATE_HITTED = 3;
  
  public static final float WIDTH = 0.8f;
  public static final float HEIGHT = 0.8f;

}
