package hoo;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArticleDao dao = new ArticleDao();
		
		while(true) {
			System.out.println("��ɾ� �Է� : ");
			String cmd = sc.next();
			if(cmd.contentEquals("exit")) {
				System.out.println("����");
				break;
			}
			if(cmd.equals("add")) {
				Article a = new Article();
				
				System.out.println("�Խù� ������ �Է����ּ���. : ");
				String title = sc.next();
				a.setTitle(title);
				
				System.out.println("�Խù� ������ �Է����ּ���. : ");
				String body = sc.next();
				a.setBody(body);
				
				a.setNickname("�͸�");
				
				dao.insertArticle(a);
				System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			}
			if(cmd.equals("list")) {
				ArrayList<Article> articles = dao.getArticles();
				
				printArticles(articles);
			}
			if(cmd.equals("update")) {
				
				System.out.println("������ �Խù� ���� : ");
				int targetId = sc.nextInt();
				Article target = dao.getArticleById(targetId);
				
				if(target == null) {
					System.out.println("���� �Խù��Դϴ�.");
				} else {
					System.out.println("�Խù� ������ �Է����ּ���. : ");
					String newTitle = sc.next();
					System.out.println("�Խù� ������ �Է����ּ���. : ");
					String newBody = sc.next();
					
					target.setTitle(newTitle);
					target.setBody(newBody);
					
					break;
				}
			}
			
			if(cmd.equals("delete")) {
				ArrayList<Article> articles = dao.getArticles();
				System.out.println("������ �Խù� ���� : ");
				int targetId = sc.nextInt();
				Article target = dao.getArticleById(targetId);
				
				if(target == null) {
					System.out.println("�Խù��� �������� �ʽ��ϴ�.");
				} else {
					dao.removeArticle(target);
				}
			}
			
			if(cmd.equals("read")) {
				System.out.println("�󼼺��� �� �Խù� ���� : ");
				int targetId = sc.nextInt();
				Article target = dao.getArticleById(targetId);
				
				if(target == null) {
					System.out.println("�Խù��� �������� �ʽ��ϴ�.");
				} else {
					target.setHit(target.getHit() + 1);
					System.out.println("====" + target.getId() + "====");
					System.out.println("��ȣ : " + target.getId());
					System.out.println("���� : " + target.getTitle());
					System.out.println("���� : " + target.getBody());
					System.out.println("===================");
					
					while(true) {
						System.out.println("�󼼺��� ����� �������ּ���");
						System.out.println("1. ��� ���, 2. ���ƿ�, 3. ����, 4. ����, 5. ������� :");
						
						int  readCmd = sc.nextInt();
						if(readCmd == 1) {
							System.out.println("[��� ���]");
						} else if(readCmd == 2) {
							System.out.println("[���ƿ� ���]");
						} else if(readCmd == 3) {
							System.out.println("[���� ���]");
						} else if(readCmd == 4) {
							System.out.println("[���� ���]");
						} else if(readCmd == 5){
							System.out.println("[�������]");
							break;
						}
					}
				}
			}
			
			if(cmd.equals("search")) {
				System.out.println("�˻� �׸��� �������ּ���. : ");
				System.out.println("1. ����, 2. ����, 3. ���� + ����, 4. �ۼ��� :");
				int flag = sc.nextInt();
				System.out.println("�˻� Ű���带 �Է����ּ��� : ");
				String keyword = sc.next();
				ArrayList<Article> searchedArticles;
				
				SearchedArticles = dao.getSearchedArticlesByflag(flag, keyword);
				
				printArticles(searchedArticles);
			}
			
		}

	}
	private static void printArticles(ArrayList<Article> articleList) {
		for(int i = 0; i <articleList.size(); i++) {
			Article article = articleList.get(i);
			System.out.println("��ȣ : " + article.getId());
			System.out.println("���� : " + article.getTitle());
			System.out.println("��ϳ�¥ : " + article.getRegDate());
			System.out.println("�ۼ��� : " + article.getNickname());
			System.out.println("��ȸ�� : " + article.getHit());
			System.out.println("=====================");
		}
	}

}
