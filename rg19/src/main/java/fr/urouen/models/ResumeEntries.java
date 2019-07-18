package fr.urouen.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "resumes",namespace = "http://univ.fr/rg19")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResumeEntries {
    @XmlElement(name = "resume")
    private List<ResumeEntry> resumes;

    public ResumeEntries() {
        this.resumes = new LinkedList<ResumeEntry>();
    }

    public ResumeEntries(List<Entry> entries) {
        this();
        for (Entry entry : entries){
            this.resumes.add(new ResumeEntry(entry));
        }
    }

    public void addResume(ResumeEntry resume){
        this.resumes.add(resume);
    }

    public List<ResumeEntry> getResumes(){
        return resumes;
    }
}
