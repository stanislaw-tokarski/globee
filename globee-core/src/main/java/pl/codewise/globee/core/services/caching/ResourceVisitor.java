package pl.codewise.globee.core.services.caching;

public interface ResourceVisitor {

    void visit(AwsResourceIdWithRegion.Instance instance);

    void visit(AwsResourceIdWithRegion.LaunchConfiguration launchConfiguration);

    void visit(AwsResourceIdWithRegion.AutoScalingGroup autoScalingGroup);
}
