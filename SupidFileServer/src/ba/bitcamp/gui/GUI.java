package ba.bitcamp.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileSystemView;


public class GUI extends JFrame {
	private static final long serialVersionUID = 4986913590079798715L;
	private JPanel mainPanel = new JPanel();
	private JPanel lowerPanel = new JPanel();
	private JButton download = new JButton("Download");
	private JButton upload = new JButton("Upload");
	private JButton delete = new JButton("Delete");
	private JList<String> list = new JList<>();
	private FileSystemView view;

	private File f1 = new File("/img/1.jpg");
	private File f2 = new File("/img/2.jpg");
	private File f3 = new File("/img/3.jpg");
	private File f4 = new File("/img/4.jpg");
	private File f5 = new File("/img/5.jpg");

	public GUI() {
		
		Vector<String> v = new Vector<>();
		
		list.setBackground(Color.LIGHT_GRAY.brighter());
		list.setSelectionBackground(Color.DARK_GRAY.brighter().brighter());
		
		list.setListData(v);
		
		list.setSelectionModel(new SelectionModel());
		
		v.addElement(f1.getName());
		v.addElement(f2.getName());
		v.addElement(f3.getName());
		v.addElement(f4.getName());
		v.addElement(f5.getName());

		setLayout(new BorderLayout());

		add(mainPanel, BorderLayout.CENTER);
		add(lowerPanel, BorderLayout.SOUTH);
		lowerPanel.setLayout(new GridLayout(1, 3));
		lowerPanel.add(download);
		lowerPanel.add(upload);
		lowerPanel.add(delete);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new JScrollPane(list));

		download.addActionListener(new ActionListener() {
			JFileChooser downloadChooser = new JFileChooser();

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!list.isSelectionEmpty()) {
					if (e.getSource() == download) {
						int status = downloadChooser.showSaveDialog(download);
						if(status == JFileChooser.APPROVE_OPTION){
							File selectedFile = downloadChooser.getSelectedFile();
						}
					}
				}else{
					JOptionPane.showMessageDialog(mainPanel, "Please select a file !", "No file selected", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});

		upload.addActionListener(new ActionListener() {
			JFileChooser uploadChooser = new JFileChooser();

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == upload) {
					int status = uploadChooser.showOpenDialog(upload);
					if (status == JFileChooser.APPROVE_OPTION) {
						File selectedFile = uploadChooser.getSelectedFile();
					}
				}
			}
		});

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
