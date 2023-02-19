// クライアントの要求を待機して接続があったら文字列を送信する機能

package SocketGUI20230219;

import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket01 {

    public static final int PORT = 9999;

    public static void main(String[] args) {

        // このクラスをインスタンス化
        ServerSocket01 serversocketclass = new ServerSocket01();

        try {
            // サーバーソケットのインスタンス作成
            // ポートを指定して作成
            // java.net.ServerSocketクラスをインポートしているから使える
            ServerSocket serversocket = new ServerSocket(PORT);
            // サーバ側の処理
            System.out.println("クライアントからの接続の待機をしています");
            // ループ
            while (true) {
                // java.net.Socketクラスのインスタンス作成
                // accept:サーバソケット側がクライアントからの要求を受け付ける
                Socket socket = serversocket.accept();
                // サーバ側の処理
                System.out.println("サーバソケットでクライアントからの要求の受付をしました");
                // PrintWriterクラス：１行書き出すためのクラスを使う=インスタンス生成
                // Buffer 一次的に保管 バッファを介して書き込むストリーム（ストリーム＝データの受け渡しの処理の総体）
                // バッファーを使って入出力を効率化する

                // 書き込む内容をバッファに保存して書き込んだ内容を出力させる。
                PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
                // getOutputStream():ソケットの出力ストリームを返す
                // 返すにはget?
                // 書き込む内容
                pw.println("接続できました。こちらはサーバです。");
                pw.flush(); // バッファが満杯になっていなくてもバッファの内容を物理的記憶装置に書き込むよう指示したい場合にはバッファの内容を「フラッシュ」するわけです。
                // flush()がないと、いつデータがファイルに書き込まれるか定かではありません。flush()を明示的に呼ぶことで、各行がファイルに書き出されることを保障します。
                pw.close();

                // ソケットを閉じる
                socket.close();

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
