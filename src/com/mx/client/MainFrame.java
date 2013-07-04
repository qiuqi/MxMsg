package com.mx.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mx.clent.vo.MsgFriendGroup;
import com.mx.clent.vo.MsgUser;
import com.mx.client.netty.NettyClient;
import com.mx.client.webtools.ConnectionUtils;
import com.mx.client.webtools.CryptorException;
import com.mx.client.webtools.RSAEncryptor;
import com.mx.client.webtools.SConfig;

public class MainFrame extends BaseFrame {
	static Point origin = new Point();
	private static List<MsgFriendGroup> friends = new ArrayList<MsgFriendGroup>();
	private static MsgUser ower = new MsgUser();

	private static MainFrame instance;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	private MainFrame() {
		try {
			intSubstance();
			initComponents();
			String s = "test";
			try {
				System.out.println("RSA s:" + s);
				String m1 = RSAEncryptor.getInstance().myEncryptBase64Encode(s.getBytes());
				System.out.println("RSA m1:" + m1);
				String m2 = new String(RSAEncryptor.getInstance().myDecryptBase64String(m1));
				System.out.println("RSA m2:" + m2.trim());
			} catch (CryptorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public void changTryIcon(){
	// EIMTrayIcon qqTrayIcon=EIMTrayIcon.getInStance();
	// qqTrayIcon.setFrame(this);
	// qqTrayIcon.setTrayIconState(EIMClientConfig.OnlineTryIcon_Type);
	// qqTrayIcon.showIcon(EIMClientConfig.OnlineTryIcon_Type);
	// }

	private void initComponents() {
		try {
			this.setSize(340, 600);
			this.setAlwaysOnTop(true);
			setMinimumSize(new java.awt.Dimension(340, 400));
			jPanel1 = new javax.swing.JPanel();

			findField = new AutoCompletionField();
			// Cache cache=Cache.getInstance();
			// findField.setFilter(new
			// DefaultCompletionFilter(cache.getfriendMap()));
			System.out.println("1");
			headImage = new javax.swing.JLabel();
			stateComboBox = new javax.swing.JComboBox();
			personWord = new javax.swing.JLabel();
			// jToolBar1 = new javax.swing.JToolBar();

			compnayHome = new javax.swing.JButton();
			// System.out.println(this.getClass().getResource("/com/csu/client/resourse/ui/compnayHome.gif").toString());
			// Icon
			// compnayhomIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/ui/compnayHome.gif").toString(),16,16);
			// compnayHome.setIcon(compnayhomIcon);
			System.out.println("2");
			compnayEmail = new javax.swing.JButton();
			// Icon
			// compnayEmailIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/ui/Explorer.png").toString(),16,16);
			// compnayEmail.setIcon(compnayEmailIcon);

			compnayOA = new javax.swing.JButton();

			// Icon
			// oaIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/ui/oa.gif").toString(),16,16);
			// compnayOA.setIcon(oaIcon);

			news = new javax.swing.JButton();
			// Icon
			// newsIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/ui/news.gif").toString(),16,16);
			// news.setIcon(newsIcon);

			jPanel2 = new javax.swing.JPanel();
			jToolBar2 = new javax.swing.JToolBar();
			iEButton = new javax.swing.JButton();
			// Icon
			// iEIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/ui/Explorer_16.png").toString(),16,16);
			// iEButton.setIcon(iEIcon);
			personHomeButton = new javax.swing.JButton();
			// Icon
			// homIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/ui/Home.png").toString(),16,16);
			// personHomeButton.setIcon(homIcon);

			mySetButton = new javax.swing.JButton();
			// Icon
			// mySetIcon=ResourcesManagement.getImageIcon("ui/set.gif",16,16);
			// mySetButton.setIcon(mySetIcon);
			sysSetButton = new RButton(RButton.RIGHT_ROUND_RECT);
			jToolBar3 = new javax.swing.JToolBar();
			infoButton = new javax.swing.JButton();
			findButton = new javax.swing.JButton();
			// Icon
			// infoIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/ui/sysIfo.gif").toString());
			// infoButton.setIcon(infoIcon);
			// Icon
			// findIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/ui/search.gif").toString());
			// findButton.setIcon(findIcon);

			mainTabbedPanel = new SnapTipTabbedPane();
			friendPanel = new javax.swing.JPanel();
			// friendTree=new JListCustomModel();
			teamPanel = new javax.swing.JPanel();
			zuijinPanel = new javax.swing.JPanel();
			JavaLocationCollection collection = new JavaLocationCollection();
			JavaLocationListModel listModel = new JavaLocationListModel(collection);
			sampleJList = new JList(listModel);
			sampleJList.setCellRenderer(new JavaLocationRenderer());
			Font displayFont = new Font("Serif", Font.BOLD, 18);
			sampleJList.setFont(displayFont);
			sampleJList.addListSelectionListener(new ValueReporter());
			sampleJList.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if (e.getClickCount() == 2) {
						String peerid = ((JavaLocation) sampleJList.getSelectedValue()).getPeerId();
						System.out.println("peerid===" + peerid);
						ConnectionUtils.getInstance().getPubkey(peerid);
						String mMimeSend = "mime:txt:" + "helloworld!";
						String mecode = "";
						try {
							mecode = RSAEncryptor.getInstance().encryptBase64Encode(mMimeSend.getBytes(), peerid);
						} catch (CryptorException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("duid", peerid);
						map.put("msg", mecode);
						ConnectionUtils.getInstance().postTxtMessage(map);
						System.out.println();
					}
				}
			});
			// friendPanel.add(sampleJList);
			// jToolBar1.setEnabled(false);
			jToolBar2.setEnabled(false);
			jToolBar3.setEnabled(false);

			headImage.setBackground(new java.awt.Color(255, 255, 255));
			headImage.setForeground(new java.awt.Color(255, 255, 102));

			String headnum = "1";
			// Icon
			// headIcon=ResourcesManagement.getImageIcon(this.getClass().getResource("/com/csu/client/resourse/head/"+headnum+".gif").toString());

			// headImage.setIcon(headIcon);
			headImage.setMinimumSize(new java.awt.Dimension(42, 15));

			stateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3",
					"Item 4" }));

			personWord.setText(ower.getPersonWord());

			// compnayHome.setText("��˾��ҳ");
			// jToolBar1.add(compnayHome);

			// compnayEmail.setText("��˾����");
			// jToolBar1.add(compnayEmail);

			// compnayOA.setText("��˾OA");
			// jToolBar1.add(compnayOA);

			// news.setText("��˾����");
			// jToolBar1.add(news);

			javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1Layout.setHorizontalGroup(jPanel1Layout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(
							jPanel1Layout
									.createSequentialGroup()
									.addContainerGap()
									.addComponent(headImage, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(
											jPanel1Layout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
													.addComponent(stateComboBox,
															javax.swing.GroupLayout.PREFERRED_SIZE, 85,
															javax.swing.GroupLayout.PREFERRED_SIZE)
													.addComponent(personWord, javax.swing.GroupLayout.DEFAULT_SIZE,
															179, Short.MAX_VALUE)).addContainerGap())
					// .addComponent(jToolBar1,
					// javax.swing.GroupLayout.DEFAULT_SIZE, 200,
					// Short.MAX_VALUE)
					.addComponent(findField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
			jPanel1Layout
					.setVerticalGroup(jPanel1Layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									javax.swing.GroupLayout.Alignment.TRAILING,
									jPanel1Layout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													jPanel1Layout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING, false)
															.addComponent(headImage,
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE)
															.addGroup(
																	jPanel1Layout
																			.createSequentialGroup()
																			.addComponent(
																					stateComboBox,
																					javax.swing.GroupLayout.PREFERRED_SIZE,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					javax.swing.GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(personWord)))
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
													javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											// .addComponent(jToolBar1,
											// javax.swing.GroupLayout.PREFERRED_SIZE,
											// 25,
											// javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(findField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
													javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)));

			// jToolBar2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("\u5feb\u6377")));
			// iEButton.setText("\u6d4f\u89c8\u5668");
			// jToolBar2.add(iEButton);

			// personHomeButton.setText("\u4e2a\u4eba\u4e3b\u9875");
			// jToolBar2.add(personHomeButton);

			// mySetButton.setText("\u6211\u7684\u8bbe\u7f6e");
			// jToolBar2.add(mySetButton);

			sysSetButton.setText("jButton5");

			infoButton.setText("\u4fe1\u606f");
			jToolBar3.add(infoButton);

			findButton.setText("\u67e5\u627e");
			jToolBar3.add(findButton);

			javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
			jPanel2.setLayout(jPanel2Layout);
			jPanel2Layout
					.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					// .addComponent(jToolBar2,
					// javax.swing.GroupLayout.DEFAULT_SIZE, 245,
					// Short.MAX_VALUE)
							.addGroup(
									jPanel2Layout
											.createSequentialGroup()
											.addComponent(sysSetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 169,
													Short.MAX_VALUE)));
			jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(
							jPanel2Layout
									.createSequentialGroup()
									// .addComponent(jToolBar2,
									// javax.swing.GroupLayout.PREFERRED_SIZE,
									// 48,
									// javax.swing.GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(
											jPanel2Layout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
													.addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 31,
															Short.MAX_VALUE)
													.addComponent(sysSetButton, javax.swing.GroupLayout.PREFERRED_SIZE,
															31, javax.swing.GroupLayout.PREFERRED_SIZE))));

			javax.swing.GroupLayout friendPanelLayout = new javax.swing.GroupLayout(friendPanel);
			friendPanel.setLayout(friendPanelLayout);
			friendPanelLayout.setHorizontalGroup(friendPanelLayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addComponent(sampleJList,
					javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE));
			friendPanelLayout.setVerticalGroup(friendPanelLayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addComponent(sampleJList,
					javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE));

			mainTabbedPanel.addTab("\u597d\u53cb\u5217\u8868", friendPanel);

			javax.swing.GroupLayout teamPanelLayout = new javax.swing.GroupLayout(teamPanel);
			teamPanel.setLayout(teamPanelLayout);
			teamPanelLayout.setHorizontalGroup(teamPanelLayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 240, Short.MAX_VALUE));
			teamPanelLayout.setVerticalGroup(teamPanelLayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 260, Short.MAX_VALUE));
			mainTabbedPanel.addTab("\u7fa4\u5217\u8868", teamPanel);

			javax.swing.GroupLayout zuijinPanelLayout = new javax.swing.GroupLayout(zuijinPanel);
			zuijinPanel.setLayout(zuijinPanelLayout);
			zuijinPanelLayout.setHorizontalGroup(zuijinPanelLayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 240, Short.MAX_VALUE));
			zuijinPanelLayout.setVerticalGroup(zuijinPanelLayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 260, Short.MAX_VALUE));
			mainTabbedPanel.addTab("\u6700\u8fd1\u8054\u7cfb\u4eba", zuijinPanel);

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(layout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE)
					.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE)
					.addComponent(mainTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
					layout.createSequentialGroup()
							.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(mainTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					setVisible(false);
				}
			});
			this.setMainColor(new java.awt.Color(102, 204, 255));
			this.setAlwaysOnTop(true);
			NettyClient client = null;
			try {
				client = new NettyClient("https://www.han2011.com/" + "/getmessage/"
						+ SConfig.getInstance().getProfile().getSession() + "/call.xml");
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Thread thread = new Thread(client);
			thread.setDaemon(true);
			thread.start();
			System.out.println("线程启动");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public void initMainTree(List<MsgFriendGroup> groupList){
	// TreeScrollPane treeScrollPane=new TreeScrollPane(groupList);
	// friendTree=treeScrollPane;
	// this.repaint();
	// }
	public void setMainColor(Color bg) {
		mainTabbedPanel.setBackground(bg);
		friendPanel.setBackground(bg);
		teamPanel.setBackground(bg);
		zuijinPanel.setBackground(bg);
		jPanel1.setBackground(bg);
		jPanel2.setBackground(bg);
		// jToolBar1.setBackground(bg);
		// jToolBar2.setBackground(bg);
		jToolBar3.setBackground(bg);
		// jToolBar1.setForeground(bg);
		// jToolBar2.setForeground(bg);
		jToolBar3.setForeground(bg);

	}

	public static List<MsgFriendGroup> getFriends() {
		return friends;
	}

	public static void setFriends(List<MsgFriendGroup> friends) {
		MainFrame.friends = friends;
	}

	public static MsgUser getOwer() {
		return ower;
	}

	public static void setOwer(MsgUser ower) {
		MainFrame.ower = ower;
	}

	// public TreeScrollPane getFriendTree() {
	// return friendTree;
	// }
	//
	// public void setFriendTree(TreeScrollPane friendTree) {
	// this.friendTree = friendTree;
	// }

	// �������� - �������޸�
	private javax.swing.JButton compnayEmail;
	private javax.swing.JButton compnayHome;
	private javax.swing.JButton compnayOA;
	private javax.swing.JButton findButton;
	private AutoCompletionField findField;
	private javax.swing.JPanel friendPanel;
	// private JListCustomModel friendTree;
	private javax.swing.JLabel headImage;
	private javax.swing.JButton iEButton;
	private javax.swing.JButton infoButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	// private javax.swing.JToolBar jToolBar1;
	private javax.swing.JToolBar jToolBar2;
	private javax.swing.JToolBar jToolBar3;
	private JList sampleJList;
	private SnapTipTabbedPane mainTabbedPanel;
	private javax.swing.JButton mySetButton;
	private javax.swing.JButton news;
	private javax.swing.JButton personHomeButton;
	private javax.swing.JLabel personWord;
	private javax.swing.JComboBox stateComboBox;
	private RButton sysSetButton;
	private javax.swing.JPanel teamPanel;
	private javax.swing.JPanel zuijinPanel;

	// ������������
	public static void main(String[] args) {
		try {
			EventQueue.invokeLater(new Runnable() {

				public void run() {
					// TODO Auto-generated method stub
					final MainFrame frame = new MainFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setUndecorated(true);
					frame.addMouseListener(new MouseListener() {

						public void mouseReleased(MouseEvent arg0) {
							// TODO Auto-generated method stub

						}

						public void mousePressed(MouseEvent arg0) {
							// TODO Auto-generated method stub
							origin.x = arg0.getX();
							origin.y = arg0.getY();
						}

						public void mouseExited(MouseEvent arg0) {
							// TODO Auto-generated method stub

						}

						public void mouseEntered(MouseEvent arg0) {
							// TODO Auto-generated method stub

						}

						public void mouseClicked(MouseEvent arg0) {
							// TODO Auto-generated method stub

						}
					});

					frame.addMouseMotionListener(new MouseMotionListener() {

						public void mouseMoved(MouseEvent arg0) {
							// TODO Auto-generated method stub

						}

						public void mouseDragged(MouseEvent arg0) {
							// TODO Auto-generated method stub
							Point p = frame.getLocation();

							frame.setLocation(p.x + arg0.getX() - origin.x, p.y + arg0.getY() - origin.y);
						}
					});
					frame.setVisible(true);

				}
			});

			// System.out.println(EIMMainFrame.class.getResource("/com/csu/client/resourse/ui/compnayHome.gif").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class ValueReporter implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (!e.getValueIsAdjusting())
				System.out.println(((JavaLocation) sampleJList.getSelectedValue()).getPeerId());

		}
	}
}
