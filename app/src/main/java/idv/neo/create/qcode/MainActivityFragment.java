package idv.neo.create.qcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import idv.neo.utils.BitmapUtils;
import idv.neo.utils.QRCodeUtils;

/**
 * A placeholder fragment containing a simple view.
 */
//https://goo.gl/AwDX9X
//http://oldgrayduck.blogspot.tw/2015/11/android-studio-zxing-qr-code.html
//http://gnehcic.azurewebsites.net/android%E5%BB%BA%E7%AB%8Bqr-code/
//http://hao2debug.blogspot.tw/2014/01/androidzxingqrcode.html
public class MainActivityFragment extends Fragment {
    private static final String TAG = MainActivityFragment.class.getSimpleName();
    // QR code 寬度
    private int QRCodeWidth = 200;
    // QR code 高度
    private int QRCodeHeight = 200;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText input = (EditText) root.findViewById(R.id.input);
        final ImageView showqcode = (ImageView) root.findViewById(R.id.showqcode);
        final Button create = (Button) root.findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// 設定 QR code 容錯率為 H 容錯率姑且可以將它想像成解析度，分為 4 級：L(7%)，M(15%)，Q(25%)，H(30%)
// ZXing 還可以生成其他形式條碼，如：BarcodeFormat.CODE_39、BarcodeFormat.CODE_93、BarcodeFormat.CODE_128、BarcodeFormat.EAN_8、BarcodeFormat.EAN_13...
// 設定為 QR code 影像
                showqcode.setImageBitmap(BitmapUtils.getQR_CodeBitmap(null, QRCodeUtils.createQR_Code_DateMatrix(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H, input.getText().toString(), QRCodeWidth, QRCodeHeight), QRCodeWidth, QRCodeHeight));
            }
        });
        return root;
    }
}
