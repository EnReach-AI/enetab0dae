package p125o0;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import p001A.C0009j;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: o0.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1804n implements SensorEventListener {

    /* JADX INFO: renamed from: a */
    public C0009j f6223a;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i3) {
        AbstractC0147a.f354a.contains(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            if (this.f6223a != null) {
                float[] fArr = sensorEvent.values;
                double d = fArr[0] / 9.80665f;
                double d3 = fArr[1] / 9.80665f;
                double d4 = fArr[2] / 9.80665f;
                if (Math.sqrt((d4 * d4) + (d3 * d3) + (d * d)) > 2.299999952316284d) {
                    this.f6223a.m32J();
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}
