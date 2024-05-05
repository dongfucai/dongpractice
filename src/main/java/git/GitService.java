package git;


import org.eclipse.jgit.api.*;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.JacksonUtil;

import java.io.File;
import java.util.*;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2019/11/18 下午2:17
 * @Version 1.0
 **/

public class GitService {
    private static final Logger logger = LoggerFactory.getLogger(GitService.class);
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    public static void main(String[] args) {

        String path = "/Users/dongfucai/Downloads/code/dongpractice";
        //gitGetLog(path);
       // getStatusFiles(path);
        RetObj retObj = gitGetChangedFiles(path);
        System.out.println(JacksonUtil.toJsonStrWithEmptyDefault(retObj));

    }
    /**
     * 查看git日志
     */
    public static RetObj gitGetLog(String localPath) {
        try {
            Git git = Git.open(new File(localPath));
            LogCommand logCommand = git.log();
            Iterable<RevCommit> commitLst = logCommand.call();

            List<String> allLogs = new ArrayList<String>();
            for (RevCommit revCommit : commitLst) {
                logger.info("FullMessage: " + revCommit.getFullMessage());
                logger.info("Name: " + revCommit.getName());
                allLogs.add(revCommit.toString());
            }

            git.close();
            return new RetObj(SUCCESS, allLogs.toArray());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getLog error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 获取当前改变的文件
     */
    public static RetObj gitGetChangedFiles(String localPath) {
        try {
            Git git = Git.open(new File(localPath));
            StatusCommand statusCommand = git.status();
            Status status = statusCommand.call();

            Map<String, Set<String>> result = new HashMap<String, Set<String>>();
            Set<String> addedSet = status.getAdded();
            result.put("added", addedSet);

            Set<String> changededSet = status.getChanged();
            result.put("changed", changededSet);

            Set<String> missedSet = status.getMissing();
            result.put("missed", missedSet);

            Set<String>  uncommittedChanges = status.getUncommittedChanges();
            result.put("uncommittedChanges", uncommittedChanges);

            git.close();
            return new RetObj(SUCCESS, result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getChangedFiles error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 获取当前本地分支
     */
    public static RetObj gitGetCurrentLocalBranch(String localPath) {
        try {
            Git git = Git.open(new File(localPath));
            String currentBranch = git.getRepository().getBranch();
            git.close();
            return new RetObj(SUCCESS, currentBranch);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getCurrentLocalBranch error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 获取当前远程分支
     */
    public static RetObj gitGetCurrentRemoteBranch(String localPath) {
        try {
            Git git = Git.open(new File(localPath));
            RetObj localBranchObj = gitGetCurrentLocalBranch(localPath);
            if (!localBranchObj.getStatus().equals(SUCCESS)) {
                git.close();
                return new RetObj(FAILURE, localBranchObj.getResult());
            }

            String currentBranch = (String) localBranchObj.getResult();
            StoredConfig storedConfig = git.getRepository().getConfig();
            String remoteBranch = storedConfig.getString("branch", currentBranch, "remote");
            git.close();
            return new RetObj(SUCCESS, remoteBranch);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getCurrentRemoteBranch error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 获取所有远程配置
     */
    public static RetObj gitGetRemotes(String localPath) {
        try {
            Git git = Git.open(new File(localPath));
            RemoteListCommand remoteListCommand = git.remoteList();
            List<RemoteConfig> rcLst = remoteListCommand.call();
            List<String> result = new ArrayList<String>();
            for (RemoteConfig rc : rcLst) {
                result.add(rc.getName());
            }
            git.close();
            return new RetObj(SUCCESS, result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getRemotes error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 克隆仓库
     */
    public static RetObj gitCloneRepository(String remoteUrl, String localPath) {
        try {
            logger.info(String.format("Downloading %s to %s ...", remoteUrl, localPath));
            CloneCommand cloneCommand = Git.cloneRepository().setURI(remoteUrl);
            cloneCommand.setDirectory(new File(localPath));
            Git git = cloneCommand.call();
            git.close();
            logger.info(String.format("Download %s to %s finished", remoteUrl, localPath));
            return new RetObj(SUCCESS, String.format("Clone repository %s to %s successfully", remoteUrl, localPath));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("gitCloneRepository error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 更新仓库
     */
    public static RetObj gitPullRepository(String localPath) {
        try {
            Git git = Git.open(new File(localPath));
            PullCommand pullCommand = git.pull();
            pullCommand.call();
            git.close();
            return new RetObj(SUCCESS, String.format("pull repository successfully to %s", localPath));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("gitPullRepository error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }


    public static RetObj getStatusFiles(String localPath) {

        try {
            Git git = Git.open(new File(localPath));
            StatusCommand statusCommand = git.status();


            List<String> stringList = statusCommand.getPaths();
            System.out.println(JacksonUtil.toJsonStrWithEmptyDefault(stringList));


            git.close();
            return new RetObj(SUCCESS, stringList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getStatusFiles error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }

    }

    /**
     * 提交本地代码
     */
    public static RetObj gitCommitRepository(String localPath, String message) {
        try {
            Git git = Git.open(new File(localPath));
            AddCommand addCommand = git.add();
            addCommand.addFilepattern(".");
            addCommand.call();

            RmCommand rmCommand = git.rm();
            rmCommand.addFilepattern(".");
            rmCommand.call();

            CommitCommand commitCommand = git.commit();
            commitCommand.setAll(true);
            commitCommand.setMessage(message);
            commitCommand.setAllowEmpty(true);
            commitCommand.call();

            git.close();
            return new RetObj(SUCCESS, String.format("commit to repository successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("gitCommitRepository error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 提交到远程仓库
     */
    public static RetObj gitPushRepository(String localPath, String usr, String pwd) {
        try {
            Git git = Git.open(new File(localPath));
            PushCommand pushCommand = git.push();
            CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(usr, pwd);
            pushCommand.setCredentialsProvider(credentialsProvider);
            pushCommand.setForce(true).setPushAll();

            Iterable<PushResult> iter = pushCommand.call();
            for(PushResult pushResult : iter){
                logger.info(pushCommand.toString());
            }
            git.close();
            return new RetObj(SUCCESS, String.format("push to repository successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("gitPushRepository error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 获取本地所有分支名
     */
    public static RetObj gitGetLocalBranchNames(String localPath) {
        try {
            List<String> result= new LinkedList<String>();
            Git git = Git.open(new File(localPath));
            Map<String, Ref> m = git.getRepository().getAllRefs();
            Set<String> keys = m.keySet();
            logger.info("All branches: " + keys.toString());
            for(String b : keys){
                if(b.contains("ref/heads")){
                    String el = b.substring(b.lastIndexOf("/") + 1, b.length());
                    result.add(el);
                    logger.info("[ refs/heads ] branches: " + b);
                }
            }

            git.close();
            return new RetObj(SUCCESS, result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("gitGetLocalBranchNames error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 根据名称获取所有远程分支
     */
    public static RetObj gitGetRemoteBranchNames(String localPath, String remote) {
        try {
            List<String> result= new LinkedList<String>();
            Git git = Git.open(new File(localPath));
            Map<String, Ref> m = git.getRepository().getAllRefs();
            Set<String> keys = m.keySet();
            logger.info("All branches: " + keys.toString());

            String index = "refs/remotes/" + remote;
            for(String b : keys){
                if(b.contains(index)){
                    result.add(b);
                    logger.info("[ refs/remotes ] branches: " + b);
                }
            }

            git.close();
            return new RetObj(SUCCESS, result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("gitGetRemoteBranchNames error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

    /**
     * 切换分支
     */
    public static RetObj gitSwitchBranch(String localPath, String branch) {
        try {
            Git git = Git.open(new File(localPath));
            String newBranch = branch.substring(branch.lastIndexOf("/") + 1, branch.length());
            CheckoutCommand checkoutCommand = git.checkout();

            RetObj lbRet = gitGetLocalBranchNames(localPath);
            if(!lbRet.getStatus().equals(SUCCESS)){
                git.close();
                return new RetObj(FAILURE, lbRet.getResult());
            }

            List<String> lst = (List<String>)lbRet.getResult();
            if(!lst.contains(newBranch)){
                checkoutCommand.setStartPoint(branch);
                checkoutCommand.setCreateBranch(true);
            }
            checkoutCommand.setName(newBranch);
            checkoutCommand.call();

            git.close();
            return new RetObj(SUCCESS, "switch to branch " + branch + " successfully");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("gitSwitchBranch error: " + e.getMessage());
            return new RetObj(FAILURE, e.getMessage());
        }
    }

}
