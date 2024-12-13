package springlabs.news.test;

public class BeansTester {
    private final TestBean firstBean;
    private final TestBean secondBean;

    public BeansTester(TestBean firstBean, TestBean secondBean) {
        this.firstBean = firstBean;
        this.secondBean = secondBean;
    }

    public void compareBeans() {
        System.out.println("\n" +
                "Bean1 is equal to Bean2: " + (firstBean == secondBean));
    }
}