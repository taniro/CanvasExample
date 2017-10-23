package tads.eaj.com.canvasexample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Taniro on 28/09/2016.
 */

public class MinhaView extends View {

    private Paint pincelVermelho;
    private Paint pincelPreto;
    private Paint pincelAzul;

    public MinhaView(Context context) {
        this(context, null);
    }

    public MinhaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //escolhe uma cor para o fundo
        setBackgroundColor(Color.LTGRAY);

        // Vermelho
        pincelVermelho = new Paint();
        pincelVermelho.setARGB(255, 255, 0, 0);
        // Preto
        pincelPreto = new Paint();
        pincelPreto.setARGB(255, 0, 0, 0);
        // Azul
        pincelAzul = new Paint();
        pincelAzul.setARGB(255, 0, 0, 255);
        // Configura a View para receber foco e tratar eventos de teclado
        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        // Desenha um quadrado
        canvas.drawRect(
                toPixels(20),
                toPixels(20),
                toPixels(100),
                toPixels(100),
                pincelAzul);
        // Desenha uma linha
        canvas.drawLine(
                toPixels(100),
                toPixels(100),
                toPixels(200),
                toPixels( 200),
                pincelPreto);
        // Desenha um circulo
        canvas.drawCircle(
                toPixels(200),
                toPixels(200),
                toPixels(50),
                pincelVermelho);

    }

    public float toPixels(float dip) {
        Context context;
        context = getContext();
        Resources r = context.getResources();
        float densidade = r.getDisplayMetrics().density;
        // Densidade da tela
        int px = (int) (dip * densidade + 0.5f);
        return dip;
    }
}
