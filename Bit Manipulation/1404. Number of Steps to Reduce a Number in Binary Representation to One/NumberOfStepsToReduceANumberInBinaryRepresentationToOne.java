public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

    public int numSteps(String s) {
        int step = 0;
        int p = s.length() - 1;
        int nextStepShouldAddOne = 0;
        while (p > 0) {
            if (s.charAt(p) == '1' && nextStepShouldAddOne == 0) {
                nextStepShouldAddOne = 1;
                step++;
            } else if (s.charAt(p) == '1' && nextStepShouldAddOne == 1) {
                nextStepShouldAddOne = 1;
            } else if (s.charAt(p) == '0' && nextStepShouldAddOne == 1) {
                nextStepShouldAddOne = 1;
                step++;
            } else {
                nextStepShouldAddOne = 0;
            }
            p--;
            step++;
        }
        if (nextStepShouldAddOne == 1) {
            step++;
        }
        return step;
    }

}