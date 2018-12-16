package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Controller", group="4719")

public class Controller extends LinearOpMode {


    HardwareP robot = new HardwareP();


    @Override
    public void runOpMode() {


        robot.init(hardwareMap);

        telemetry.addData("Say", "Hello Driver");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

/*
            float gamepad1LeftY = -gamepad1.left_stick_y;
            float gamepad1LeftX = gamepad1.left_stick_x;
            float gamepad1RightX = gamepad1.right_stick_x;

            // holonomic formulas

            float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
            float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
            float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
            float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;

            // clip the right/left values so that the values never exceed +/- 1
            FrontRight = Range.clip(FrontRight, -1, 1);
            FrontLeft = Range.clip(FrontLeft, -1, 1);
            BackLeft = Range.clip(BackLeft, -1, 1);
            BackRight = Range.clip(BackRight, -1, 1);

            // write the values to the motors
            robot.rightFront.setPower(FrontRight / 1.25);
            robot.leftFront.setPower(-FrontLeft / 1.25);
            robot.leftBack.setPower(-BackLeft / 1.25);
            robot.rightBack.setPower(BackRight / 1.25);
            */

            robot.rightFront.setPower(-gamepad1.left_stick_y);
            robot.leftBack.setPower(-gamepad1.left_stick_y);
            robot.leftFront.setPower(gamepad1.left_stick_x);
            robot.rightBack.setPower(gamepad1.left_stick_x);
            while(Math.abs(gamepad1.right_stick_x)>.1){
                robot.rightBack.setPower(-gamepad1.right_stick_x);
                robot.rightFront.setPower(-gamepad1.right_stick_x);
                robot.leftFront.setPower(gamepad1.right_stick_x);
                robot.leftBack.setPower(gamepad1.right_stick_x);
            }


            if (gamepad1.dpad_up) {
                robot.hingeMotor.setPower(.6);

            } else if (gamepad1.dpad_down) {
                robot.hingeMotor.setPower(-.6);
            } else {
                robot.hingeMotor.setPower(0);
            }



            /*
             * Telemetry for debugging
             */

        }
    }

}
