//package trabalhoPAV;
//
//import java.awt.EventQueue;
//import java.util.ArrayList;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTextArea;
//import javax.swing.JTable;
//import javax.swing.border.LineBorder;
//import java.awt.Color;
//
//public class ConsultaFrame extends JFrame {
//
//	private JPanel contentPane;
//	private FuncionarioService funcionario;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ConsultaFrame frame = new ConsultaFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public ConsultaFrame() {
//		funcionario = new FuncionarioService();
//        ArrayList<Funcionario> f1 = funcionario.listFuncionario;
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JTextArea textArea = new JTextArea();
//		textArea.setBounds(32, 29, 365, 192);
//		contentPane.add(textArea);
//		
//		
//		
//	}
//}