package com.webdriver.customrunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.java.it.Ma;
import cucumber.api.testng.CucumberExceptionWrapper;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.CucumberFeatureWrapperImpl;
import cucumber.api.testng.FeatureResultListener;
import cucumber.api.testng.TestNgReporter;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import gherkin.formatter.Formatter;
import gherkin.formatter.model.Tag;

public class CustomTestNGCucumberRunnerWithTag {
	
	 private Runtime runtime;
	    private RuntimeOptions runtimeOptions;
	    private ResourceLoader resourceLoader;
	    private FeatureResultListener resultListener;
	    private ClassLoader classLoader;

	    /**
	     * Bootstrap the cucumber runtime
	     *
	     * @param clazz Which has the cucumber.api.CucumberOptions and org.testng.annotations.Test annotations
	     */
	    public CustomTestNGCucumberRunnerWithTag(Class clazz) {
	        classLoader = clazz.getClassLoader();
	        resourceLoader = new MultiLoader(classLoader);

	        RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(clazz);
	        runtimeOptions = runtimeOptionsFactory.create();
	        
	        addTagtoTheRunner(runtimeOptions);
	        
	        TestNgReporter reporter = new TestNgReporter(System.out);
	        ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
	        resultListener = new FeatureResultListener(runtimeOptions.reporter(classLoader), runtimeOptions.isStrict());
	        runtime = new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
	    }

		private void addTagtoTheRunner(RuntimeOptions runtimeOptions) {
			String tag = System.getProperty("TagName");
			
			if(!tag.isEmpty()){
				runtimeOptions.getFilters().add(tag);
			}
			
		}

		/**
	     * Run the Cucumber features
	     */
	    public void runCukes() {
	        for (CucumberFeature cucumberFeature : getFeatures()) {
	            cucumberFeature.run(
	                    runtimeOptions.formatter(classLoader),
	                    resultListener,
	                    runtime);
	        }
	        finish();
	        if (!resultListener.isPassed()) {
	            throw new CucumberException(resultListener.getFirstError());
	        }
	    }

	    public void runCucumber(CucumberFeature cucumberFeature) {
	        resultListener.startFeature();
	        cucumberFeature.run(
	                runtimeOptions.formatter(classLoader),
	                resultListener,
	                runtime);

	        if (!resultListener.isPassed()) {
	            throw new CucumberException(resultListener.getFirstError());
	        }
	    }

	    public void finish() {
	        Formatter formatter = runtimeOptions.formatter(classLoader);

	        formatter.done();
	        formatter.close();
	        runtime.printSummary();
	    }

	    /**
	     * @return List of detected cucumber features
	     */
	    
	    /**
	     * Map<featuename,featureObject>
	     * 
	     * */
	    
	    public List<CucumberFeature> getFeatures() {
	    	//List<CucumberFeature> modifiedList = getModifiedFeatureList();
	    	/*for (CucumberFeature cucumberFeature : featureList) {
				if(value.equalsIgnoreCase(cucumberFeature.getGherkinFeature().getName())){
					System.out.println( " Got the Object" );
					modifiedList.add(cucumberFeature);
				}
			}*/
	    	
	        return runtimeOptions.cucumberFeatures(resourceLoader);
	    }

		private List<CucumberFeature> getModifiedFeatureList() {
			String value[] = System.getProperty("FeatureName").split(",");
	    	List<CucumberFeature> featureList = runtimeOptions.cucumberFeatures(resourceLoader);
	    	List<CucumberFeature> modifiedList = new ArrayList<>();
	    	
	    	Map<String, CucumberFeature> featureMap = getFeatureMap(featureList);
	    	
	    	for (int i = 0; i < value.length; i++) {
				modifiedList.add(featureMap.get(value[i]));
			}
			return modifiedList;
		}

	    private Map<String, CucumberFeature> getFeatureMap(List<CucumberFeature> featureList) {
			Map<String, CucumberFeature> featureMap = new HashMap<>();
			
			for (CucumberFeature cucumberFeature : featureList) {
				featureMap.put(cucumberFeature.getGherkinFeature().getName(),cucumberFeature);
			}
			return featureMap;
		}
	    
	    private List<CucumberFeature> addTagToTheFeatureFile(List<CucumberFeature> featureList){
	    	String tag = System.getProperty("TagName");
	    	List<CucumberFeature> modifiedList = new ArrayList<>();
	    	for (CucumberFeature cucumberFeature : featureList) {
	    		cucumberFeature.getGherkinFeature().getTags().add(new Tag(tag, 0));
	    		modifiedList.add(cucumberFeature);
				
			}
	    	return modifiedList;
	    }
	    
	    private List<CucumberFeature> removeTagFromFeatureFile(List<CucumberFeature> featureList){
	    	List<CucumberFeature> modifiedList = new ArrayList<>();
	    	for (CucumberFeature cucumberFeature : featureList) {
	    		cucumberFeature.getGherkinFeature().getTags().clear();
	    		modifiedList.add(cucumberFeature);
				
			}
	    	return modifiedList;
	    }

		/**
	     * @return returns the cucumber features as a two dimensional array of
	     * {@link CucumberFeatureWrapper} objects.
	     */
	    public Object[][] provideFeatures() {
	        try {
	            List<CucumberFeature> features = getFeatures();
	            List<Object[]> featuresList = new ArrayList<Object[]>(features.size());
	            for (CucumberFeature feature : features) {
	                featuresList.add(new Object[]{new CucumberFeatureWrapperImpl(feature)});
	            }
	            return featuresList.toArray(new Object[][]{});
	        } catch (CucumberException e) {
	            return new Object[][]{new Object[]{new CucumberExceptionWrapper(e)}};
	        }
	    }

}
