//�T�[�o����̕��������M���ĕ\������@�\�����N���C�A���g�N���X

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
    public static final String HOST = "localhost"; // final������ƃI�[�o�[���C�h����Ȃ�
    public static final int PORT = 9999;

    private TextArea texta;
    private Button btn;

    // static�@�ÓI�F�ŏ��������Ă����Ă��ς��Ȃ����� �N���X���\�b�h�̒�`��
    // ���X�ϐ��̎��ɂ���

    public static void main(String[] arg) {
        launch(arg);
    }

    public void start(Stage stage) throws Exception {

        try {
            InetAddress ia = InetAddress.getLocalHost();

            // �R���g���[���̍쐬
            texta = new TextArea();
            btn = new Button("�T�[�o�Ɛڑ�");

            // �y�C���̍쐬
            BorderPane bp = new BorderPane();

            // �y�C���̒ǉ�
            bp.setCenter(texta);
            bp.setBottom(btn);

            // �C�x���g�n���h���̓o�^
            btn.setOnAction(new SampleEventHandler());

            // �V�[���̍쐬
            Scene sc = new Scene(bp, 300, 200);

            // �X�e�[�W�ւ̒ǉ�
            stage.setScene(sc);

            // �X�e�[�W�̕\��
            stage.setTitle("�N���C�A���g�̃T���v��");
            stage.show();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // �C�x���g�n���h���N���X
    class SampleEventHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {

            try {
                Socket socket = new Socket(HOST, PORT);
                // ���̓X�g���[���̍쐬
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // ������̓ǂݍ���
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
