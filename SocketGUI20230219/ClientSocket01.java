//サーバからの文字列を受信して表示する機能をもつクライアントクラス

package SocketGUI20230219;

import java.io.*;
import java.net.*;
// import jakarta.Application.*;
// import jakarta.stage.*;
// import jakarta.scene.*;
// import jakarta.scene.control.*;
// import jakarta.scene.layout.*;
// import jakarta.scene.input.*;

// import javafx.controls.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class ClientSocket01 extends Application {
    public static final String HOST = "localhost"; // finalをつけるとオーバーライドされない
    public static final int PORT = 9999;

    private TextArea texta;
    private Button btn;

    // static　静的：最初から作っておいても変わらないもの クラスメソッドの定義や
    // ラス変数の時につける

    public static void main(String[] arg) {
        launch(arg);
    }

    public void start(Stage stage) throws Exception {

        try {
            InetAddress ia = InetAddress.getLocalHost();

            // コントロールの作成
            texta = new TextArea();
            btn = new Button("サーバと接続");

            // ペインの作成
            BorderPane bp = new BorderPane();

            // ペインの追加
            bp.setCenter(texta);
            bp.setBottom(btn);

            // イベントハンドラの登録
            btn.setOnAction(new SampleEventHandler());

            // シーンの作成
            Scene sc = new Scene(bp, 300, 200);

            // ステージへの追加
            stage.setScene(sc);

            // ステージの表示
            stage.setTitle("クライアントのサンプル");
            stage.show();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // イベントハンドラクラス
    class SampleEventHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {

            try {
                Socket socket = new Socket(HOST, PORT);
                // 入力ストリームの作成
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 文字列の読み込み
                String str = br.readLine();
                texta.setText(str);
                br.close();
                socket.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
