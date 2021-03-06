/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2015
 *
 * Name: Zhengri Fan, Jiayu Huang
 * Date: 2015-3-28
 * Time: 16:43:32
 *
 * Project: csci205
 * Package: hw01.Model.MathBasic
 * File: LengthNotAPowerOfTwoException
 * Description: Project2 Math Model Exception
 *
 * ****************************************
 */
package hw02.Model.MathBasic;

/**
 * Throwed when the length of the array used for DFT is not a power of 2
 *
 * @author Zhengri Fan
 */
public class LengthNotAPowerOfTwoException extends Exception {

    public LengthNotAPowerOfTwoException(String errMsg) {
        super(errMsg);
    }
}
