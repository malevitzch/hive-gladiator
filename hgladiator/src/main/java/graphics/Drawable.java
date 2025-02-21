package graphics;
import core.Transform;

import core.*;

public abstract class Drawable {
   public abstract void draw(Window pTarget, Transform pTransform);
   public Drawable(){
      renderSettings = new RenderSettings(TopologyType.Triangles);
   }
   void setRenderSettings(RenderSettings pSettings){
     renderSettings = pSettings;
   }

   public static class RenderSettings{
      public RenderSettings(TopologyType pType){
         type = pType;
      }
      public TopologyType type;
   }

   RenderSettings getRenderSettings(){
      return renderSettings;
   }

   protected  RenderSettings renderSettings;
}
