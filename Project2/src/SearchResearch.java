
public class SearchResearch {
	public static void main(String[] args)
	{
		PublicationSystem system = new PublicationSystem();
		//system.importPublication();
		String[] titles={"title1","title2","title3","title4","title5"};
		System.out.println("Title	|		1.			2.			3.			4.			5.");
		System.out.println("Order");
		System.out.println("-------			---------		---------		---------		---------		---------");
		system.sortByBibliographicInfo();
		System.out.print("BI");
		System.out.println("\t\t\t"+system.getSearchComparisonsBI(titles[0])+"\t\t\t"+system.getSearchComparisonsBI(titles[1])+"\t\t\t"+system.getSearchComparisonsBI(titles[2])+"\t\t\t"+system.getSearchComparisonsBI(titles[3])+"\t\t\t"+system.getSearchComparisonsBI(titles[4]));
		system.sortByAuthor();
		System.out.println("AN");
		System.out.println("\t\t\t"+system.getSearchComparisonsLI(titles[0])+"\t\t\t"+system.getSearchComparisonsLI(titles[1])+"\t\t\t"+system.getSearchComparisonsLI(titles[2])+"\t\t\t"+system.getSearchComparisonsLI(titles[3])+"\t\t\t"+system.getSearchComparisonsLI(titles[4]));
		system.sortByPaperTitle();
		System.out.println("PT");
		System.out.println("\t\t\t"+system.getSearchComparisonsBI(titles[0])+"\t\t\t"+system.getSearchComparisonsBI(titles[1])+"\t\t\t"+system.getSearchComparisonsBI(titles[2])+"\t\t\t"+system.getSearchComparisonsBI(titles[3])+"\t\t\t"+system.getSearchComparisonsBI(titles[4]));
		system.sortBySerialTitle();
		System.out.println("ST");
		System.out.println("\t\t\t"+system.getSearchComparisonsLI(titles[0])+"\t\t\t"+system.getSearchComparisonsLI(titles[1])+"\t\t\t"+system.getSearchComparisonsLI(titles[2])+"\t\t\t"+system.getSearchComparisonsLI(titles[3])+"\t\t\t"+system.getSearchComparisonsLI(titles[4]));
		system.sortByDate();
		System.out.println("Ch");
		System.out.println("\t\t\t"+system.getSearchComparisonsLI(titles[0])+"\t\t\t"+system.getSearchComparisonsLI(titles[1])+"\t\t\t"+system.getSearchComparisonsLI(titles[2])+"\t\t\t"+system.getSearchComparisonsLI(titles[3])+"\t\t\t"+system.getSearchComparisonsLI(titles[4]));
		system.randomSort();
		System.out.println("R");
		System.out.println("\t\t\t"+system.getSearchComparisonsLI(titles[0])+"\t\t\t"+system.getSearchComparisonsLI(titles[1])+"\t\t\t"+system.getSearchComparisonsLI(titles[2])+"\t\t\t"+system.getSearchComparisonsLI(titles[3])+"\t\t\t"+system.getSearchComparisonsLI(titles[4]));
		
	}
}
