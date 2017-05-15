import utils.GlobalFlags;

/**
 * Created by Antoha on 5/7/2017.
 */
public class Main {

    public static void main(String[] args) {
        GlobalFlags.PARAM_FLAG = args.length > 0;
        if (GlobalFlags.PARAM_FLAG) {
            ParamsProcessor pp = new ParamsProcessor();
            pp.processParams(args);
        }
        Program p = new Program();
        p.startProgram();
    }

}
