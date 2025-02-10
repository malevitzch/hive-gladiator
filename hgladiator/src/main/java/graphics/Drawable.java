package graphics;
import core.Transform;

import java.awt.*;

public interface Drawable {
   void draw(Graphics pContext, Transform pTransform);
}
