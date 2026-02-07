abstract class AbstractAssessmentFlow
{
    public final void executeAssessment()
    {
        System.out.println("Initializing assessment...");
        validate();
        prepare();
        evaluate();
        publishResult();
        System.out.println("Assessment finished.");
    }
    
    protected final void validate()
    {
        System.out.println("Checking student credentials...");
    }
    
    protected void prepare()
    {
        System.out.println("Loading question set...");
    }
    
    protected abstract void evaluate();
    
    protected void publishResult()
    {
        System.out.println("Saving results to database...");
    }
}

interface AutoAssessment
{    
    default void evaluate()
    {
        System.out.println("Running automated grading...");
    }
    
    default void generateAIReport()
    {
        System.out.println("Creating performance report...");
    }
}

interface ManualAssessment
{    
    default void evaluate()
    {
        System.out.println("Manual review in progress...");
    }
    
    default void requestHumanReview()
    {
        System.out.println("Sending to instructor for review...");
    }
}

public class UnifiedAssessmentExecutor extends AbstractAssessmentFlow implements AutoAssessment, ManualAssessment
{    
    private boolean isProctored;
    private String studentId;
    private String courseCode;
    private String assessmentType;
    
    public UnifiedAssessmentExecutor(boolean isProctored, String studentId, String courseCode, String assessmentType)
    {
        this.isProctored = isProctored;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.assessmentType = assessmentType;
    }
    
    @Override
    public void evaluate()
    {
        System.out.println("Processing " + studentId + " - " + courseCode + " (" + (isProctored ? "proctored" : "online") + ")");
        
        if (isProctored)
            {
            ManualAssessment.super.evaluate();
        } 

        else
        {
            AutoAssessment.super.evaluate();
        }
        
        System.out.println("Verification complete.");
    }
    
    @Override
    protected void prepare()
    {
        super.prepare();
        System.out.println("Configuring " + assessmentType + "...");
    }
    
    public void setProctored(boolean isProctored)
    {
        this.isProctored = isProctored;
        System.out.println("Mode switched to " + (isProctored ? "supervised" : "self-paced"));
    }
    
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
    
    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }
    
    public void generateUnifiedReport()
    {
        System.out.println("Preparing assessment report...");
        if (isProctored) {
            requestHumanReview();
        } 
        
        else
        {
            generateAIReport();
        }
    }
    
    public static void main(String[] args) 
    {
        System.out.println("University Assessment System v1.2");
        
        System.out.println("\nTest 1: Online Quiz");

        UnifiedAssessmentExecutor autoQuiz = new UnifiedAssessmentExecutor 
        (
            false, "24BCS10785", "24CSH-204", "Online Quiz"
        );

        autoQuiz.executeAssessment();
        
        System.out.println("\nTest 2: Final Exam");

        UnifiedAssessmentExecutor proctoredExam = new UnifiedAssessmentExecutor(true, "24BCS10785", "J24BCS-127", "EST Exam");
        proctoredExam.executeAssessment();
        
        System.out.println("\nTest 3: Mode Switch");
        autoQuiz.setProctored(true);
        autoQuiz.executeAssessment();
        
        System.out.println("\nAll tests completed.");
    }
}