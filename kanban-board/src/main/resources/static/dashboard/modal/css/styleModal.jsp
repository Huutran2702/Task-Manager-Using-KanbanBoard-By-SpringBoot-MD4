<style>
    .button {
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0.8rem;
        padding: 0.4rem 0.8rem;
        cursor: pointer;
        transition: all 60ms ease-in-out;
        text-align: center;
        white-space: nowrap;
        text-decoration: none;
        appearance: none;
        line-height: 1.3;
        font-weight: 500;
        text-transform: capitalize;
    ;
        color: #4a4a4a;
        background-color: #f2f2f2;
        border: 0 none;
        border-radius: 3px;
    }

    .button:hover {
        transition: all 60ms ease;
        opacity: .85;
    }

    .button:active {
        text-decoration: none;
        transition: all 60ms ease;
        transform: scale(0.97);
        opacity: .75;
    }

    .button:visited {
        text-decoration: none;
    }

    .button.good {
        color: #FFFFF3;
        background: #47b8e0;
    }
    .button.button-bordered {
        color: #FFFFF3;
        border: 2px solid #FFFFF3;
        background: transparent;
    }
    .button.button-bordered:hover, .button.button-bordered:active {
        color: #ff7473;
        border-color: #FFFFF3;
        background: #FFFFF3;
    }

    /*************/
    /*   MODAL   */
    /*************/
    /* The Modal (background) */

    .modal {
        display: none;
        /* Hidden by default */
        position: fixed;
        /* Stay in place */
        z-index: 1;
        /* Sit on top */
        left: 0;
        top: 0;
        width: 100%;
        /* Full width */
        height: 100%;
        /* Full height */
        overflow: hidden;
        /* Enable scroll if needed */
        background-color: #A593E0;
        /* Black w/ opacity */
        transition: all 0.5s ease 0.06s;
    }


    /* Modal Content/Box */

    .modal-content {
        background-color: #fff;
        margin: 15% auto;
        /* 15% from the top and centered */
        padding: 1.2rem;
        max-width: 30%;
        /* Could be more or less, depending on screen size */
        visibility: hidden;
        box-shadow: 2px 2px 10px 0px rgba(99, 106, 119, 0.6);
        border-radius: 5px;
    }


    /* The Close Button */

    .close {
        color: #dedede;
        /*float: right;*/
        font-size: 2rem;
        font-weight: bold;
        display: flex;
        align-items: center;
    }

    .close:before {
        content: "Close";
        font-size: 1rem;
        display: none;
        text-decoration: none;
        align-self: center;
        margin-top: 0.2rem;
        font-weight: 400;
    }

    .close:hover:before {
        display: initial;
        color: #dedede;
    }

    .close:hover,
    .close:focus {
        color: hsl(0, 100%, 70%);
        text-decoration: none;
        cursor: pointer;
    }

    .close:active,
    .close:before:active {
        transition: all 60ms ease;
        transform: scale(0.97);
    }


    /***********************/
    /*  modal form layout  */
    /***********************/

    .modal-content {
        display: flex;
        flex-direction: column;
    }

    .modal-header {
        display: flex;
        flex-direction: row-reverse;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 1rem;
        font-size: 2em;
        font-weight: bold;
    }

    .modal-footer {
        display: flex;
        flex-direction: row-reverse;
        align-items: center;
    }

    .modal-footer > input {
        margin-top: 0.8rem;
        margin-bottom: 0rem;
        margin-left: 0rem;
        margin-right: 0rem;
    }

    .modal-form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .form-row {
        display: flex;
        width: 100%;
        align-items: center;
        padding: 0.4rem 0.4rem;
    }

    .form-row:nth-child(odd) {
        background: #f2f2f2;
    }

    .form-row label {
        flex-grow: 1;
        flex-shrink: 0;
        flex-basis: 50%;
    }

    .form-row input,
    .form-row select {
        flex-grow: 1;
        flex-shrink: 1;
        flex-basis: 50%;
        border: 1px solid hsl(0, 0%, 90%);
        padding: 0.2rem 0.2rem;
        max-width: 50%;
    }

    .slideDown {
        animation-name: slideDown;
        -webkit-animation-name: slideDown;
        animation-duration: 0.6s;
        -webkit-animation-duration: 0.6s;
        animation-timing-function: ease;
        -webkit-animation-timing-function: ease;
        visibility: visible !important;
    }
    @keyframes slideDown {
        0% {
            transform: translateY(-100%);
        }
        50%{
            transform: translateY(4%);
        }
        65%{
            transform: translateY(-2%);
        }
        80%{
            transform: translateY(2%);
        }
        95%{
            transform: translateY(-1%);
        }
        100% {
            transform: translateY(0%);
        }
    }

</style>
