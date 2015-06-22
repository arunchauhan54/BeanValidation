package bean.validation.group;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class,FirstValidationGroup.class,ChildValidationGroup.class})
public interface ValidationSequence {

}
