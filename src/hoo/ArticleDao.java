package hoo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ArticleDao {
	private static ArrayList<Article> articles;
	private int no = 4;
	
	public ArticleDao() {
		articles = new ArrayList<>();
		Article a1 = new Article(1, "ù��°", "ù��°����", "�͸�", getCurrentDate());
		Article a2 = new Article(1, "�ι�°", "�ι�°����", "�͸�", getCurrentDate());
		Article a3 = new Article(1, "����°", "����°����", "�͸�", getCurrentDate());
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
	}
	public void insertArticle(Article a) {
		a.setId(no);
		no++;
		a.setRegDate(getCurrentDate());
		
		articles.add(a);
	}
	public void removeArticle(Article a) {
		articles.remove(a);
	}
	private static String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
		Date time = new Date();
		String time1 = format.format(time);
		
		return time1;
	}
	public ArrayList<Article> getArticles(){
		return articles;
	}
	public static Article getArticleById(int targetId) {
		for(int i =0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if(id == targetId) {
				return articles.get(i);
			}
		}
		return null;
	}
	public ArrayList<Article> getSearchedByFlag(int flag, String Keyword){
		ArrayList<Article> searchedArticles = new ArrayList<>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			String str = article.getPropertiesByFlag(flag);
			if (str.contains(keyword)) {
				searchedArticles.add(article);
			}
		}

		return searchedArticles;
	}
	public ArrayList<Article> getSearchedArticlesByBody(String keyword) {
		ArrayList<Article> searchedArticles = new ArrayList<>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			String str = article.getBody(); // �� �Խù� ����
			if (str.contains(keyword)) {
				searchedArticles.add(article);
			}
		}

		return searchedArticles;
	}
}
}
