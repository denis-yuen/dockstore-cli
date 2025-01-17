package io.dockstore.client.cli.nested;

import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class WesCommandParser {

    public WesMain wesMain;
    public CommandLaunch commandLaunch;
    public CommandCancel commandCancel;
    public CommandStatus commandStatus;
    public CommandServiceInfo commandServiceInfo;
    public JCommander jCommander;

    public WesCommandParser() {
        this.wesMain = new WesMain();
        this.commandLaunch = new CommandLaunch();
        this.commandCancel = new CommandCancel();
        this.commandStatus = new CommandStatus();
        this.commandServiceInfo = new CommandServiceInfo();

        this.jCommander = buildWesCommandParser();
    }

    private JCommander buildWesCommandParser() {

        // Build JCommander
        return JCommander.newBuilder()
            .addObject(this.wesMain)
            .addCommand("launch", this.commandLaunch)
            .addCommand("cancel", this.commandCancel)
            .addCommand("status", this.commandStatus)
            .addCommand("service-info", this.commandServiceInfo)
            .build();
    }

    @Parameters(separators = "=", commandDescription = "Execute WES commands")
    public static class WesMain {
        @Parameter(names = "--wes-url", description = "The URL of the WES server.", required = false)
        private String wesUrl = null;
        @Parameter(names = "--help", description = "Prints help for launch command", help = true)
        private boolean help = false;

        public String getWesUrl() {
            return wesUrl;
        }

        public boolean isHelp() {
            return help;
        }
    }

    @Parameters(separators = "=", commandDescription = "Launch a workflow using WES")
    public static class CommandLaunch extends WesMain {
        @Parameter(names = "--entry", description = "Complete workflow path in Dockstore (ex. NCI-GDC/gdc-dnaseq-cwl/GDC_DNASeq:master)", required = true)
        private String entry;
        @Parameter(names = "--json", description = "JSON file describing which attached file contains input parameters.")
        private String json;
        @Parameter(names = {"--attach", "-a"}, description = "A list of paths to files that should be included in the WES request. (ex. -a <path1> <path2> OR -a <path1> -a <path2>)", variableArity = true)
        private List<String> attachments;

        public String getEntry() {
            return entry;
        }

        public String getJson() {
            return json;
        }

        public List<String> getAttachments() {
            return attachments;
        }
    }

    @Parameters(separators = "=", commandDescription = "Cancel a remote WES entry")
    public static class CommandCancel extends WesMain {
        @Parameter(names = "--id", description = "The ID of the workflow to cancel", required = true)
        private String id;

        public String getId() {
            return id;
        }
    }

    @Parameters(separators = "=", commandDescription = "Retrieve the status of a workflow")
    public static class CommandStatus extends WesMain {
        @Parameter(names = "--id", description = "The ID of the workflow to cancel", required = true)
        private String id;
        @Parameter(names = "--verbose", description = "Flag indicating to print verbose logs", required = false)
        private boolean verbose = false;

        public String getId() {
            return id;
        }

        public boolean isVerbose() {
            return verbose;
        }
    }

    @Parameters(separators = "=", commandDescription = "Retrieve info about a WES server")
    public static class CommandServiceInfo extends WesMain {
    }

}
