package pl.codewise.globee.core.client;

import com.amazonaws.regions.Regions;
import lombok.AllArgsConstructor;
import pl.codewise.commons.aws.cqrs.model.AwsAutoScalingGroup;
import pl.codewise.commons.aws.cqrs.model.ec2.AwsLaunchConfiguration;
import pl.codewise.globee.core.client.exceptions.GlobeeClientException;
import pl.codewise.globee.core.client.services.AutoScalingService;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class AutoScalingClient {

    private final AutoScalingService autoScalingService;

    public List<AwsAutoScalingGroup> searchAutoScalingGroups(String keyword) throws IOException, GlobeeClientException {
        final Response<List<AwsAutoScalingGroup>> response =
                autoScalingService.searchAutoScalingGroups(keyword).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        throw new GlobeeClientException("Globee returned HTTP " + response.code());
    }

    public List<AwsAutoScalingGroup> getAutoScalingGroups() throws IOException, GlobeeClientException {
        final Response<List<AwsAutoScalingGroup>> response = autoScalingService.getAutoScalingGroups().execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        throw new GlobeeClientException("Globee returned HTTP " + response.code());
    }

    public List<AwsAutoScalingGroup> getAutoScalingGroups(Regions region) throws IOException, GlobeeClientException {
        final Response<List<AwsAutoScalingGroup>> response =
                autoScalingService.getAutoScalingGroups(region.getName()).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        throw new GlobeeClientException("Globee returned HTTP " + response.code());
    }

    public AwsAutoScalingGroup getAutoScalingGroup(String autoScalingGroupName)
            throws IOException, GlobeeClientException {
        final Response<List<AwsAutoScalingGroup>> response =
                autoScalingService.getAutoScalingGroup(autoScalingGroupName).execute();
        return GlobeeClient.fetchResource(response);
    }

    public List<AwsLaunchConfiguration> searchLaunchConfigurations(String keyword)
            throws IOException, GlobeeClientException {
        final Response<List<AwsLaunchConfiguration>> response =
                autoScalingService.searchLaunchConfigurations(keyword).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        throw new GlobeeClientException("Globee returned HTTP " + response.code());
    }

    public List<AwsLaunchConfiguration> getLaunchConfigurations() throws IOException, GlobeeClientException {
        final Response<List<AwsLaunchConfiguration>> response =
                autoScalingService.getLaunchConfigurations().execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        throw new GlobeeClientException("Globee returned HTTP " + response.code());
    }

    public List<AwsLaunchConfiguration> getLaunchConfigurations(Regions region)
            throws IOException, GlobeeClientException {
        final Response<List<AwsLaunchConfiguration>> response =
                autoScalingService.getLaunchConfigurations(region.getName()).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        throw new GlobeeClientException("Globee returned HTTP " + response.code());
    }

    public AwsLaunchConfiguration getLaunchConfiguration(String launchConfigurationName)
            throws IOException, GlobeeClientException {
        final Response<List<AwsLaunchConfiguration>> response =
                autoScalingService.getLaunchConfiguration(launchConfigurationName).execute();
        return GlobeeClient.fetchResource(response);
    }
}
